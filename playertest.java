package playercount;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.fs.Path;


public class playertest {

  public static void main(String[] args) throws Exception {

    /*
     * Validate that two arguments were passed from the command line.
     */
	 Configuration conf = new Configuration();

	//String[] otherArgs = {"/home/cloudera/workspace/playercount/player.txt", "/home/cloudera/workspace/playercount/output"};
    if (args.length != 2) {
      System.out.printf("Usage: StubDriver <input dir> <output dir>\n");
      System.exit(-1);
    }

    /*
     * Instantiate a Job object for your job's configuration. 
     */
    Job job = Job.getInstance(conf, "playertest");

    /*
     * Specify the jar file that contains your driver, mapper, and reducer.
     * Hadoop will transfer this jar file to nodes in your cluster running 
     * mapper and reducer tasks.
     */
    job.setJarByClass(playertest.class);
    job.setMapperClass(playermapper.class);
    job.setCombinerClass(playerreducer.class);
    job.setReducerClass(playerreducer.class);

    
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(LongWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    /*
    for (int i = 0; i < otherArgs.length - 1; ++i) {

        FileInputFormat.addInputPath(job, new Path(otherArgs[i]));

       }

       FileOutputFormat.setOutputPath(job, new Path(otherArgs[otherArgs.length - 1]));
*/
    /*
     * Specify an easily-decipherable name for the job.
     * This job name will appear in reports and logs.
     */

    /*
     * TODO implement
     */
    
    /*
     * Start the MapReduce job and wait for it to finish.
     * If it finishes successfully, return 0. If not, return 1.
     */
       System.exit(job.waitForCompletion(true) ? 0 : 1);
    
  }
}