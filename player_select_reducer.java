package playercount;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;


public class player_select_reducer extends Reducer<Text, playerbean, Text, playerbean>{
	
	public void reduce(Text key, Iterable<playerbean> values, Reducer<Text, playerbean, Text, playerbean>.Context context)
		      throws IOException, InterruptedException {
			  long sum_kick_score=0;
			  float sum_kick_avg=0;
			  for (playerbean a : values){
				  sum_kick_score += a.getkick_score();
				  sum_kick_avg += a.getkick_avg();
			  }
			  
			  
			  context.write(key,new playerbean(sum_kick_score,sum_kick_avg));
		    
		  }

}
