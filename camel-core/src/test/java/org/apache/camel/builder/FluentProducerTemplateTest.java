/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.builder;

import org.apache.camel.ContextTestSupport;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.RuntimeCamelException;
import org.apache.camel.component.mock.MockEndpoint;

/**
 * Unit test for DefaultProducerTemplate
 */
public class FluentProducerTemplateTest extends ContextTestSupport {

    public void testIn() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedBodiesReceived("Bye World");

        Object result = FluentProducerTemplate.on(context)
            .withBody("Hello World")
            .to("direct:in")
            .request();

        assertMockEndpointsSatisfied();

        assertEquals("Bye World", result);

        assertSame(context, template.getCamelContext());
    }

    public void testInOut() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedBodiesReceived("Bye Bye World");

        Object result = FluentProducerTemplate.on(context)
            .withBody("Hello World")
            .to("direct:out")
            .request();

        assertMockEndpointsSatisfied();

        assertEquals("Bye Bye World", result);
    }

    public void testFault() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(0);

        Object result = FluentProducerTemplate.on(context)
            .withBody("Hello World")
            .to("direct:fault")
            .request();

        assertMockEndpointsSatisfied();

        assertEquals("Faulty World", result);
    }

    // TODO: to review
    public void testExceptionUsingBody() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(0);

        Exchange out =  FluentProducerTemplate.on(context)
            .withBody("Hello World")
            .to("direct:exception")
            .send();

        assertTrue(out.isFailed());
        assertTrue(out.getException() instanceof IllegalArgumentException);
        assertEquals("Forced exception by unit test", out.getException().getMessage());

        /*
        try {
            Exchange out =  FluentProducerTemplate.on(context)
                .withBody("Hello World")
                .to("direct:exception")
                .send();

            assertTrue(out.isFailed());
            fail("Should have thrown RuntimeCamelException");
        } catch (RuntimeCamelException e) {
            assertTrue(e.getCause() instanceof IllegalArgumentException);
            assertEquals("Forced exception by unit test", e.getCause().getMessage());
        }
        */

        assertMockEndpointsSatisfied();
    }

    // TODO: to review
    public void testExceptionUsingProcessor() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(0);

        Exchange out = FluentProducerTemplate.on(context)
            .withProcessor(exchange -> exchange.getIn().setBody("Hello World"))
            .to("direct:exception")
            .send();

        assertTrue(out.isFailed());
        assertEquals("Forced exception by unit test", out.getException().getMessage());

        assertMockEndpointsSatisfied();
    }

    public void testExceptionUsingExchange() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(0);

        Exchange out = FluentProducerTemplate.on(context)
            .withExchange(() -> {
                    Exchange exchange = context.getEndpoint("direct:exception").createExchange();
                    exchange.getIn().setBody("Hello World");

                    return exchange;
                })
            .to("direct:exception")
            .send();

        assertTrue(out.isFailed());
        assertEquals("Forced exception by unit test", out.getException().getMessage());

        assertMockEndpointsSatisfied();
    }

    public void testRequestExceptionUsingBody() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(0);

        try {
            FluentProducerTemplate.on(context)
                .withBody("Hello World")
                .to("direct:exception")
                .request();

            fail("Should have thrown RuntimeCamelException");
        } catch (RuntimeCamelException e) {
            assertTrue(e.getCause() instanceof IllegalArgumentException);
            assertEquals("Forced exception by unit test", e.getCause().getMessage());
        }

        assertMockEndpointsSatisfied();
    }

    public void testRequestExceptionUsingProcessor() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(0);

        Exchange out = FluentProducerTemplate.on(context)
            .withProcessor(exchange -> exchange.getIn().setBody("Hello World"))
            .to("direct:exception")
            .request(Exchange.class);

        assertTrue(out.isFailed());
        assertEquals("Forced exception by unit test", out.getException().getMessage());

        assertMockEndpointsSatisfied();
    }

    public void testRequestExceptionUsingExchange() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(0);

        Exchange out = FluentProducerTemplate.on(context)
            .withExchange(() -> {
                    Exchange exchange = context.getEndpoint("direct:exception").createExchange(ExchangePattern.InOut);
                    exchange.getIn().setBody("Hello World");

                    return exchange;
                })
            .to("direct:exception")
            .send();

        assertTrue(out.isFailed());
        assertEquals("Forced exception by unit test", out.getException().getMessage());

        assertMockEndpointsSatisfied();
    }

    public void testRequestBody() throws Exception {
        // with endpoint as string uri
        FluentProducerTemplate template = FluentProducerTemplate.on(context);

        final Integer expectedResult = new Integer(123);

        assertEquals(
            expectedResult,
            template.clearBody()
                .clearHeaders()
                .withBody("Hello")
                .to("direct:inout")
                .request(Integer.class)
        );

        assertEquals(
            expectedResult,
            template.clearBody()
                .clearHeaders()
                .withHeader("foo", "bar")
                .withBody("Hello")
                .to("direct:inout")
                .request(Integer.class)
        );

        assertEquals(
            expectedResult,
            template.clearBody()
                .clearHeaders()
                .withBody("Hello")
                .to("direct:inout")
                .request(Integer.class)
        );

        assertEquals(
            expectedResult,
            template.clearBody()
                .clearHeaders()
                .withBody("Hello")
                .to(context.getEndpoint("direct:inout"))
                .request(Integer.class)
        );

        assertEquals(
            expectedResult,
            template.clearBody()
                .clearHeaders()
                .withHeader("foo", "bar")
                .withBody("Hello")
                .to(context.getEndpoint("direct:inout"))
                .request(Integer.class)
        );

        assertEquals(
            expectedResult,
            template.clearBody()
                .clearHeaders()
                .withBody("Hello")
                .to(context.getEndpoint("direct:inout"))
                .request(Integer.class)
        );
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            public void configure() throws Exception {
                // for faster unit test
                errorHandler(noErrorHandler());

                from("direct:in").process(
                        exchange -> exchange.getIn().setBody("Bye World"))
                    .to("mock:result");

                from("direct:out").process(
                        exchange -> exchange.getOut().setBody("Bye Bye World"))
                    .to("mock:result");

                from("direct:fault").process(
                        exchange -> {
                                exchange.getOut().setFault(true);
                                exchange.getOut().setBody("Faulty World");
                            })
                    .to("mock:result");

                from("direct:exception").process(
                        exchange -> {
                                throw new IllegalArgumentException("Forced exception by unit test");
                            })
                    .to("mock:result");

                from("direct:inout").transform(constant(123));
            }
        };
    }
}
