package playercount;
import java.io.IOException;
import java.io.DataInput;
import java.io.DataOutput;
import org.apache.hadoop.io.Writable;


public class playerbean implements Writable {
	//private long year_p;
	private long kick_score;
	private float kick_avg;
	
	public playerbean(){
		
	}
	
	public playerbean(long kick_score,float kick_avg){
		//this.year_p=year_p;
		this.kick_avg = kick_avg;
		this.kick_score = kick_score;
		
	}
	/*
	public long getyear(){
		return year_p;
	}
	
	public void setyear(long year_p){
		this.year_p=year_p;
	}
	*/
	public long getkick_score(){
		return kick_score;
	}
	
	public void setkick_score(long kick_score){
		this.kick_score = kick_score;
	}
	
	public float getkick_avg(){
		return kick_avg;
	}
	
	public void setkick_avg(float kick_avg){
		this.kick_avg = kick_avg;
	}
	
	public void write(DataOutput out) throws IOException {
		//out.writeLong(year_p);
		out.writeLong(kick_score);
		out.writeFloat(kick_avg);
		
	}
	
	public void readFields(DataInput in) throws IOException {
		//year_p = in.readLong();
		kick_score = in.readLong();
		kick_avg = in.readFloat();
	}
	
	public String toString(){
		return kick_score+"\t"+kick_avg;
	}
}
