Used for testing and benchmarking effectively-once semantics in an Apache Pulsar source connector.

### Prerequisites
A prerequisite for effectively-once semantics in Apache Pulsar is that you have [enabled message deduplication](https://pulsar.apache.org/docs/en/cookbooks-deduplication/#how-it-works).

### Create
```
./pulsar-admin sources create --name seq --destinationTopicName seq --source-type sequence_source --processing-guarantees EFFECTIVELY_ONCE
```

### Restart
```
./pulsar-admin sources restart --name seq
```
With `--processing-guarantees EFFECTIVELY_ONCE` pulsar will ignore produced duplicates until the counter is higher than the last persisted sequence-id.

### Consume
```
./pulsar-client consume -n 0 -s seq seq
```

### Logs
```
tail -f /tmp/functions/public/default/seq/seq-0.log
``` 
That is the default location when using pulsar in standalone mode. By default the performance metrics are logged once a minute.
