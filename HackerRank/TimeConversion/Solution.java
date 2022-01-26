package HackerRank.TimeConversion;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'timeConversion' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts STRING s as parameter.
	 */

	public static String timeConversion(String s) {
		// Write your code here
		StringBuilder sb = new StringBuilder();
		String amPm = s.substring(8);

		if (amPm.equals("AM")) {
			if (s.substring(0, 2).equals("12")) {
				sb.append("00");
				sb.append(s.substring(2, 8));
			} else {
				sb.append(s.substring(0, 8));
			}
		} else {
			int hour = 12;
			if(s.substring(0, 2).equals("12")){
				sb.append(s.substring(0, 8));
			} else {
				sb.append(hour+Integer.parseInt(s.substring(0, 2)));
				sb.append(s.substring(2, 8));
			}

		}
		return sb.toString();
	}

}


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = Result.timeConversion(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
