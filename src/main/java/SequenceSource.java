import java.util.Map;
import java.util.Optional;
import org.apache.pulsar.functions.api.Record;
import org.apache.pulsar.io.core.SourceContext;
import org.apache.pulsar.io.core.Source;


public class SequenceSource implements Source<Long>{
    
    @Override
    public void open(Map<String, Object> config, SourceContext sourceContext) {
    }
    
    private long counter = 0;

    @Override
    public Record<Long> read() {
        
        Record<Long> rec = new Record<Long>() {
            
            private Long value = counter;

            @Override
            public Optional<String> getPartitionId() {
                return Optional.of("1"); 
            }
            
            @Override
            public Optional<Long> getRecordSequence() {
                return Optional.of(this.value); 
            }

            @Override
            public Long getValue() {
                return this.value;
            }
        };
        counter++;
        return rec;
    }

    @Override
    public void close() throws Exception {
    }
    
}