package playercount;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;


public class player_select_mapper extends Mapper<LongWritable, Text, Text, playerbean>{
	
	 public void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, playerbean>.Context context)
		      throws IOException, InterruptedException {

		    /*
		     * TODO implement
		     */
			  String line = value.toString();
			  String[] lineSplit = line.split(",");
			  String name = lineSplit[0];
			  long kick_score = Long.parseLong(lineSplit[1]);
			  float kick_avg = Float.parseFloat(lineSplit[2]);
			  long year = Long.parseLong(lineSplit[23]);
			  String name_k = name;
			  //name_key.set(name_y);
			  //score_value.set(score);
			  if(year ==2017){
			  context.write(new Text(name_k),new playerbean(kick_score,kick_avg));
			  }
			  //else context.write(new Text(name_k),new playerbean(kick_score,kick_avg));
			  
		  }

}
