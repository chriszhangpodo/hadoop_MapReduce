package playercount;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class playerreducer extends Reducer<Text, LongWritable, Text, LongWritable> {

  @Override
  public void reduce(Text key, Iterable<LongWritable> values, Context context)
      throws IOException, InterruptedException {
	  long max = 0l;
	  for (LongWritable a : values){
		  if(a.get() > max){
			  max = a.get(); 
		  }  
	  }
	  context.write(key,new LongWritable(max));
    
  }
}
