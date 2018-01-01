package playercount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class playermapper extends Mapper<LongWritable, Text, Text, LongWritable> {
	
	//private final static LongWritable score_value = new LongWritable(0);
	
	//private Text name_key = new Text();


  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

    /*
     * TODO implement
     */
	  String line = value.toString();
	  String[] lineSplit = line.split(",");
	  String name = lineSplit[0];
	  long score = Long.parseLong(lineSplit[1]);
	  long year = Long.parseLong(lineSplit[23]);
	  String name_y = name + "-" + year;
	  //name_key.set(name_y);
	  //score_value.set(score);
	  context.write(new Text(name_y),new LongWritable(score));
	  
	  
  }
}