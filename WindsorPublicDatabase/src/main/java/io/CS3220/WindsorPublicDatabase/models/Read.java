package io.CS3220.WindsorPublicDatabase.models;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class Read {

	public static String readFile(String filename) throws IOException {
		Regions clientRegion = Regions.US_EAST_2;
		String bucketName = "exceldatabase";
		String[] paths = filename.split("/");
		String key = paths[1];

		S3Object fullObject = null, objectPortion = null, headerOverrideObject = null;
		try {
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
					.withRegion(clientRegion)
					.withCredentials(new ProfileCredentialsProvider())
					.build();

			System.out.println("Downloading an object");
			fullObject = s3Client.getObject(new GetObjectRequest(bucketName, key));
			System.out.println("Content-Type: " + fullObject.getObjectMetadata().getContentType());
			System.out.println("Content: ");
			return displayTextInputStream(fullObject.getObjectContent());


		} catch (AmazonServiceException e) {
			// The call was transmitted successfully, but Amazon S3 couldn't process
			// it, so it returned an error response.
			e.printStackTrace();
		} catch (SdkClientException e) {
			// Amazon S3 couldn't be contacted for a response, or the client
			// couldn't parse the response from Amazon S3.
			e.printStackTrace();
		} finally {
			// To ensure that the network connection doesn't remain open, close any open input streams.

			}
		return "File not found";
	}

	private static String displayTextInputStream(InputStream input) throws IOException {
		// Read the text input stream one line at a time and display each line.
//    	 BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//         String line = null;
//         while ((line = reader.readLine()) != null) {
//             System.out.println(line);
//         }
//         System.out.println();
		StringBuilder sb = new StringBuilder();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		String l;
		String[] keys = {};
		int i =0;
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		while ((l = br.readLine()) != null) {
			sb.append(l);
			if(i==0){
				keys = l.split(",");
				i++;
			}
			else{
				List<String> values = new ArrayList<>();
				for(String x :l.split(","))
				{
					values.add(x);
				}
				if(i==1){
					for(int x=0;x<keys.length;x++)
					{
						map.put(keys[x],Arrays.asList(values.get(x)));


					}
					i++;
				}
				else
				{
					for(int x=0;x<keys.length;x++)
					{

						List<String> temp = new ArrayList<>();
						temp.addAll(map.get(keys[x]));
						temp.add(values.get(x));
						map.put(keys[x], temp);


					}
				}



			}

		}



		Gson gson = new Gson();
		String json = gson.toJson(map);
		return json;


	}
}