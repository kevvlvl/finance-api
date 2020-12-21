# Finance-API

The following service is part of the "Live Finance Demo".
It is a simple Spring REST reactive service that consumes the stock value generated by Finance-Data-Svc, stores those value in a DB for historical purposes and exposes RESTful apis to users who can inquire about those values

The other service "Finance-Data-Svc" produces the stocks data

## How-To

1. Ensure Kafka is started. Use the docker-compose file "Kafka-dockercompose.yml"
    ````
   docker-compose -f Kafka-dockercompose.yml up
   ````
2. Run the spring boot service
3. Monitor the logs of this service
4. Start Finance-Data-Svc and cURL its endpoint to generate a stock value (see its README.md for how-to)
5. Notice the log here showing the consumed value such as
    ````
    2020-12-21 00:09:12.440  INFO 20879 --- [ntainer#0-0-C-1] o.s.k.l.KafkaMessageListenerContainer    : stock_gid: partitions assigned: [stocks-0]
    2020-12-21 00:09:27.498  INFO 20879 --- [ntainer#0-0-C-1] c.k.f.service.impl.FinanceServiceImpl    : Stock value received: 19.223568
    2020-12-21 00:09:31.069  INFO 20879 --- [ntainer#0-0-C-1] c.k.f.service.impl.FinanceServiceImpl    : Stock value received: 19.566456
    ````