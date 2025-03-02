/*
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
package org.apache.camel.builder.endpoint;

// CHECKSTYLE:OFF
// CHECKSTYLE:OFF
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.dsl.*;
import org.apache.camel.support.ExpressionAdapter;

public interface EndpointBuilderFactory extends
// FACTORY INTERFACE UPDATE START
        AMQPEndpointBuilderFactory,
        AS2EndpointBuilderFactory,
        ActiveMQEndpointBuilderFactory,
        AhcEndpointBuilderFactory,
        ApnsEndpointBuilderFactory,
        AsteriskEndpointBuilderFactory,
        AtmosEndpointBuilderFactory,
        AtmosphereWebsocketEndpointBuilderFactory,
        AtomEndpointBuilderFactory,
        AtomixMapEndpointBuilderFactory,
        AtomixMessagingEndpointBuilderFactory,
        AtomixMultiMapEndpointBuilderFactory,
        AtomixQueueEndpointBuilderFactory,
        AtomixSetEndpointBuilderFactory,
        AtomixValueEndpointBuilderFactory,
        AvroEndpointBuilderFactory,
        BeanEndpointBuilderFactory,
        BeanValidatorEndpointBuilderFactory,
        BeanstalkEndpointBuilderFactory,
        BlobServiceEndpointBuilderFactory,
        BonitaEndpointBuilderFactory,
        BoxEndpointBuilderFactory,
        BraintreeEndpointBuilderFactory,
        BrowseEndpointBuilderFactory,
        CMEndpointBuilderFactory,
        CMISEndpointBuilderFactory,
        CaffeineCacheEndpointBuilderFactory,
        CaffeineLoadCacheEndpointBuilderFactory,
        CassandraEndpointBuilderFactory,
        ChatScriptEndpointBuilderFactory,
        ChunkEndpointBuilderFactory,
        CinderEndpointBuilderFactory,
        ClassEndpointBuilderFactory,
        ClientEndpointBuilderFactory,
        CoAPEndpointBuilderFactory,
        CometdEndpointBuilderFactory,
        ConsulEndpointBuilderFactory,
        ControlBusEndpointBuilderFactory,
        CordaEndpointBuilderFactory,
        CouchDbEndpointBuilderFactory,
        CouchbaseEndpointBuilderFactory,
        CryptoCmsEndpointBuilderFactory,
        CwEndpointBuilderFactory,
        CxfEndpointBuilderFactory,
        CxfRsEndpointBuilderFactory,
        DataFormatEndpointBuilderFactory,
        DataSetEndpointBuilderFactory,
        DataSetTestEndpointBuilderFactory,
        DdbEndpointBuilderFactory,
        DdbStreamEndpointBuilderFactory,
        DebeziumMongodbEndpointBuilderFactory,
        DebeziumMySqlEndpointBuilderFactory,
        DebeziumPostgresEndpointBuilderFactory,
        DebeziumSqlserverEndpointBuilderFactory,
        DigitalOceanEndpointBuilderFactory,
        DigitalSignatureEndpointBuilderFactory,
        DirectEndpointBuilderFactory,
        DirectVmEndpointBuilderFactory,
        DisruptorEndpointBuilderFactory,
        DisruptorVmEndpointBuilderFactory,
        DnsEndpointBuilderFactory,
        DockerEndpointBuilderFactory,
        DozerEndpointBuilderFactory,
        DrillEndpointBuilderFactory,
        DropboxEndpointBuilderFactory,
        EC2EndpointBuilderFactory,
        ECSEndpointBuilderFactory,
        EKSEndpointBuilderFactory,
        EhcacheEndpointBuilderFactory,
        ElasticsearchEndpointBuilderFactory,
        ElsqlEndpointBuilderFactory,
        EtcdEndpointBuilderFactory,
        EventAdminEndpointBuilderFactory,
        EventEndpointBuilderFactory,
        ExecEndpointBuilderFactory,
        FacebookEndpointBuilderFactory,
        FhirEndpointBuilderFactory,
        FileEndpointBuilderFactory,
        FileWatchEndpointBuilderFactory,
        FlatpackEndpointBuilderFactory,
        FlinkEndpointBuilderFactory,
        FopEndpointBuilderFactory,
        FreemarkerEndpointBuilderFactory,
        FtpEndpointBuilderFactory,
        FtpsEndpointBuilderFactory,
        GangliaEndpointBuilderFactory,
        GeoCoderEndpointBuilderFactory,
        GitEndpointBuilderFactory,
        GitHubEndpointBuilderFactory,
        GlanceEndpointBuilderFactory,
        GoogleBigQueryEndpointBuilderFactory,
        GoogleBigQuerySQLEndpointBuilderFactory,
        GoogleCalendarEndpointBuilderFactory,
        GoogleCalendarStreamEndpointBuilderFactory,
        GoogleDriveEndpointBuilderFactory,
        GoogleMailEndpointBuilderFactory,
        GoogleMailStreamEndpointBuilderFactory,
        GooglePubsubEndpointBuilderFactory,
        GoogleSheetsEndpointBuilderFactory,
        GoogleSheetsStreamEndpointBuilderFactory,
        GoraEndpointBuilderFactory,
        GrapeEndpointBuilderFactory,
        GraphqlEndpointBuilderFactory,
        GridFsEndpointBuilderFactory,
        GrpcEndpointBuilderFactory,
        GuavaEventBusEndpointBuilderFactory,
        HBaseEndpointBuilderFactory,
        HazelcastAtomicnumberEndpointBuilderFactory,
        HazelcastInstanceEndpointBuilderFactory,
        HazelcastListEndpointBuilderFactory,
        HazelcastMapEndpointBuilderFactory,
        HazelcastMultimapEndpointBuilderFactory,
        HazelcastQueueEndpointBuilderFactory,
        HazelcastReplicatedmapEndpointBuilderFactory,
        HazelcastRingbufferEndpointBuilderFactory,
        HazelcastSedaEndpointBuilderFactory,
        HazelcastSetEndpointBuilderFactory,
        HazelcastTopicEndpointBuilderFactory,
        HdfsEndpointBuilderFactory,
        HipchatEndpointBuilderFactory,
        HttpEndpointBuilderFactory,
        IAMEndpointBuilderFactory,
        IOTAEndpointBuilderFactory,
        IPFSEndpointBuilderFactory,
        IgniteCacheEndpointBuilderFactory,
        IgniteComputeEndpointBuilderFactory,
        IgniteEventsEndpointBuilderFactory,
        IgniteIdGenEndpointBuilderFactory,
        IgniteMessagingEndpointBuilderFactory,
        IgniteQueueEndpointBuilderFactory,
        IgniteSetEndpointBuilderFactory,
        InfinispanEndpointBuilderFactory,
        InfluxDbEndpointBuilderFactory,
        IrcEndpointBuilderFactory,
        IronMQEndpointBuilderFactory,
        JBPMEndpointBuilderFactory,
        JCacheEndpointBuilderFactory,
        JGroupsEndpointBuilderFactory,
        JGroupsRaftEndpointBuilderFactory,
        JMXEndpointBuilderFactory,
        JSR356WebSocketEndpointBuilderFactory,
        JcloudsEndpointBuilderFactory,
        JcrEndpointBuilderFactory,
        JdbcEndpointBuilderFactory,
        JettyHttpEndpointBuilder9Factory,
        JingEndpointBuilderFactory,
        JiraEndpointBuilderFactory,
        JmsEndpointBuilderFactory,
        JoltEndpointBuilderFactory,
        JooqEndpointBuilderFactory,
        JpaEndpointBuilderFactory,
        JsonValidatorEndpointBuilderFactory,
        Jt400EndpointBuilderFactory,
        KMSEndpointBuilderFactory,
        KafkaEndpointBuilderFactory,
        KeystoneEndpointBuilderFactory,
        KinesisEndpointBuilderFactory,
        KinesisFirehoseEndpointBuilderFactory,
        KubernetesConfigMapsEndpointBuilderFactory,
        KubernetesDeploymentsEndpointBuilderFactory,
        KubernetesHPAEndpointBuilderFactory,
        KubernetesJobEndpointBuilderFactory,
        KubernetesNamespacesEndpointBuilderFactory,
        KubernetesNodesEndpointBuilderFactory,
        KubernetesPersistentVolumesClaimsEndpointBuilderFactory,
        KubernetesPersistentVolumesEndpointBuilderFactory,
        KubernetesPodsEndpointBuilderFactory,
        KubernetesReplicationControllersEndpointBuilderFactory,
        KubernetesResourcesQuotaEndpointBuilderFactory,
        KubernetesSecretsEndpointBuilderFactory,
        KubernetesServiceAccountsEndpointBuilderFactory,
        KubernetesServicesEndpointBuilderFactory,
        KuduEndpointBuilderFactory,
        LambdaEndpointBuilderFactory,
        LanguageEndpointBuilderFactory,
        LdapEndpointBuilderFactory,
        LdifEndpointBuilderFactory,
        LogEndpointBuilderFactory,
        LuceneEndpointBuilderFactory,
        LumberjackEndpointBuilderFactory,
        MQEndpointBuilderFactory,
        MSKEndpointBuilderFactory,
        MailEndpointBuilderFactory,
        MasterEndpointBuilderFactory,
        MetricsEndpointBuilderFactory,
        MicroProfileMetricsEndpointBuilderFactory,
        MicrometerEndpointBuilderFactory,
        MiloClientEndpointBuilderFactory,
        MiloServerEndpointBuilderFactory,
        MinaEndpointBuilderFactory,
        MllpEndpointBuilderFactory,
        MockEndpointBuilderFactory,
        MongoDbEndpointBuilderFactory,
        MsvEndpointBuilderFactory,
        MustacheEndpointBuilderFactory,
        MvelEndpointBuilderFactory,
        MyBatisBeanEndpointBuilderFactory,
        MyBatisEndpointBuilderFactory,
        NagiosEndpointBuilderFactory,
        NatsEndpointBuilderFactory,
        NetWeaverEndpointBuilderFactory,
        NettyEndpointBuilderFactory,
        NettyHttpEndpointBuilderFactory,
        NeutronEndpointBuilderFactory,
        NitriteEndpointBuilderFactory,
        NovaEndpointBuilderFactory,
        NsqEndpointBuilderFactory,
        Olingo2EndpointBuilderFactory,
        Olingo4EndpointBuilderFactory,
        OpenshiftBuildConfigsEndpointBuilderFactory,
        OpenshiftBuildsEndpointBuilderFactory,
        OptaPlannerEndpointBuilderFactory,
        PahoEndpointBuilderFactory,
        PaxLoggingEndpointBuilderFactory,
        PdfEndpointBuilderFactory,
        PgEventEndpointBuilderFactory,
        PgReplicationSlotEndpointBuilderFactory,
        PlatformHttpEndpointBuilderFactory,
        PrinterEndpointBuilderFactory,
        PubNubEndpointBuilderFactory,
        PulsarEndpointBuilderFactory,
        QuartzEndpointBuilderFactory,
        QueueServiceEndpointBuilderFactory,
        QuickfixjEndpointBuilderFactory,
        RabbitMQEndpointBuilderFactory,
        ReactiveStreamsEndpointBuilderFactory,
        RedisEndpointBuilderFactory,
        RefEndpointBuilderFactory,
        RestApiEndpointBuilderFactory,
        RestEndpointBuilderFactory,
        RestSwaggerEndpointBuilderFactory,
        RobotFrameworkEndpointBuilderFactory,
        RssEndpointBuilderFactory,
        S3EndpointBuilderFactory,
        SWFEndpointBuilderFactory,
        SagaEndpointBuilderFactory,
        SalesforceEndpointBuilderFactory,
        SchedulerEndpointBuilderFactory,
        SchematronEndpointBuilderFactory,
        ScpEndpointBuilderFactory,
        SdbEndpointBuilderFactory,
        SedaEndpointBuilderFactory,
        ServerEndpointBuilderFactory,
        ServiceEndpointBuilderFactory,
        ServiceNowEndpointBuilderFactory,
        ServletEndpointBuilderFactory,
        SesEndpointBuilderFactory,
        SftpEndpointBuilderFactory,
        SipEndpointBuilderFactory,
        Sjms2EndpointBuilderFactory,
        SjmsBatchEndpointBuilderFactory,
        SjmsEndpointBuilderFactory,
        SlackEndpointBuilderFactory,
        SmppEndpointBuilderFactory,
        SnmpEndpointBuilderFactory,
        SnsEndpointBuilderFactory,
        SolrEndpointBuilderFactory,
        SoroushBotEndpointBuilderFactory,
        SparkEndpointBuilderFactory,
        SplunkEndpointBuilderFactory,
        SpringBatchEndpointBuilderFactory,
        SpringIntegrationEndpointBuilderFactory,
        SpringLdapEndpointBuilderFactory,
        SpringWebserviceEndpointBuilderFactory,
        SqlEndpointBuilderFactory,
        SqlStoredEndpointBuilderFactory,
        SqsEndpointBuilderFactory,
        SshEndpointBuilderFactory,
        StAXEndpointBuilderFactory,
        StompEndpointBuilderFactory,
        StreamEndpointBuilderFactory,
        StringTemplateEndpointBuilderFactory,
        StubEndpointBuilderFactory,
        SwiftEndpointBuilderFactory,
        TelegramEndpointBuilderFactory,
        ThriftEndpointBuilderFactory,
        TikaEndpointBuilderFactory,
        TimerEndpointBuilderFactory,
        TranslateEndpointBuilderFactory,
        TwilioEndpointBuilderFactory,
        TwitterDirectMessageEndpointBuilderFactory,
        TwitterSearchEndpointBuilderFactory,
        TwitterTimelineEndpointBuilderFactory,
        UndertowEndpointBuilderFactory,
        ValidatorEndpointBuilderFactory,
        VelocityEndpointBuilderFactory,
        VertxEndpointBuilderFactory,
        VmEndpointBuilderFactory,
        WeatherEndpointBuilderFactory,
        Web3jEndpointBuilderFactory,
        WebhookEndpointBuilderFactory,
        WebsocketEndpointBuilderFactory,
        WordpressEndpointBuilderFactory,
        WsEndpointBuilderFactory,
        XChangeEndpointBuilderFactory,
        XJEndpointBuilderFactory,
        XQueryEndpointBuilderFactory,
        XmlSignatureEndpointBuilderFactory,
        XmppEndpointBuilderFactory,
        XsltEndpointBuilderFactory,
        XsltSaxonEndpointBuilderFactory,
        YammerEndpointBuilderFactory,
        ZendeskEndpointBuilderFactory,
        ZooKeeperEndpointBuilderFactory,
        ZooKeeperMasterEndpointBuilderFactory
// FACTORY INTERFACE UPDATE END
{

    default Expression endpoints(EndpointProducerBuilder... endpoints) {
        return new ExpressionAdapter() {
            List<Expression> expressions = Stream.of(endpoints)
                    .map(EndpointProducerBuilder::expr).collect(Collectors.toList());
            @Override
            public Object evaluate(Exchange exchange) {
                return expressions.stream().map(e -> e.evaluate(exchange, Object.class))
                        .collect(Collectors.toList());
            }
        };
    }

}
