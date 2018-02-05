package com.apple.filegen;


import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.Timestamp;
class TextFileGenOneFile {
	
	public static String generateRandomSentense(){
		String[] name = {"Anu","Siv","Rubi","Sami","Sas","Anki","Yui","Sai","Rai","Shv","Suh"};
		String[] action = {"soccer", "player", "umpire"};
		String[] surity = {"hummmmm","obvious","sure","certain","Good","true"};

		int randAction = (int) (Math.random() * action.length);
		int randNms = (int) (Math.random() * name.length);
		int randNmsTwo = (int) (Math.random() * name.length);
		int randSurity = (int) (Math.random() * surity.length);
		
		String phrase1 = name[randNms];
		String phrase2 = action[randAction];
		String phrase3 = name[randNmsTwo];
		String phrase0 = surity[randSurity];
       	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp + ": It is " + phrase0 + " that " +  phrase1 + " is a better " +  phrase2 + " than " + phrase3 + "!" ;
		
	}
    public static void main(String args[]) throws Exception {
    	for (int i = 0; i < 50; i++){
    		String fileName = writeFile();
    		System.out.println("File written is : "+ fileName);
    	}
    }
    
    public static String writeFile() throws Exception {
    	String str = generateRandomSentense() + "\n";
       	byte[] buffer = str.getBytes();
		long number_of_lines = 75;

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String fileName = timestamp.getTime() + "_file.txt";
		@SuppressWarnings("resource")
		FileChannel rwChannel = new RandomAccessFile(fileName, "rw").getChannel();
		ByteBuffer wrBuf = rwChannel.map(FileChannel.MapMode.READ_WRITE, 0, buffer.length * number_of_lines);
		for (int i = 0; i < 25; i++)
		{
			wrBuf.put((generateRandomSentense() + "\n").getBytes());
		}
		rwChannel.close();
		return fileName;
    	
    }

}