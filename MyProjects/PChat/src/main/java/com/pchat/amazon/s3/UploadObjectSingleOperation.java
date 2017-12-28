package com.pchat.amazon.s3;
import java.io.File;
import java.io.IOException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class UploadObjectSingleOperation {
	private static String bucketName     = "nb-bucket-first";
	private static String fileName        = "Active New.png";
	private static String uploadFileName = "/home/nanobi/Prasad/Dev Data : D/Develop/Cleanup/Screens/Active New.png";
	
	
	public static void main(String[] args) throws IOException {
		UploadObjectSingleOperation obj = new UploadObjectSingleOperation();
		obj.upload();
    }
	
	public void upload(){
		AWSCredentials awsCredentials = new BasicAWSCredentials("", "");
		 ClientConfiguration clientConfig = new ClientConfiguration();
		 clientConfig.setProtocol(Protocol.HTTP);
		 
		 AmazonS3 s3client = new AmazonS3Client(awsCredentials, clientConfig);
		 Bucket bucket = new Bucket(bucketName);
       try {
           System.out.println("Uploading a new object to S3 from a file\n");
           File file = new File(uploadFileName);
           s3client.putObject(new PutObjectRequest(
           		                 bucketName, fileName, file));
           s3client.putObject(new PutObjectRequest(
	                 bucketName, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));
                      
        //   s3client.setObjectAcl(bucketName, fileName, CannedAccessControlList.PublicRead);
           GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucket.getName(), fileName);
           String fileUrl = s3client.generatePresignedUrl(request).toString();
           System.out.println(fileUrl.substring(0, fileUrl.indexOf("?")));
           
        } catch (AmazonServiceException ase) {
           System.out.println("Caught an AmazonServiceException, which " +
           		"means your request made it " +
                   "to Amazon S3, but was rejected with an error response" +
                   " for some reason.");
           System.out.println("Error Message:    " + ase.getMessage());
           System.out.println("HTTP Status Code: " + ase.getStatusCode());
           System.out.println("AWS Error Code:   " + ase.getErrorCode());
           System.out.println("Error Type:       " + ase.getErrorType());
           System.out.println("Request ID:       " + ase.getRequestId());
       } catch (AmazonClientException ace) {
           System.out.println("Caught an AmazonClientException, which " +
           		"means the client encountered " +
                   "an internal error while trying to " +
                   "communicate with S3, " +
                   "such as not being able to access the network.");
           System.out.println("Error Message: " + ace.getMessage());
       }
	}
}