package tuts4java;

import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;

public class JPEGcompressor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File originalImage=new File("C:\\Users\\srija\\Desktop\\javapicture.jpg");
		File compressedImage=new File("C:\\Users\\srija\\Desktop\\compressedImage.jpg");
		try {
			compressJPEGimage(originalImage,compressedImage,0.5f);
			System.out.println("Done!");
		}
		catch(IOException e){
			
		}

	}
	public static void compressJPEGimage(File originalImage,File compressedImage,float compressionQuality)throws IOException{
		RenderedImage image=ImageIO.read(originalImage);
		ImageWriter jpegWriter=ImageIO.getImageWritersByFormatName("jpg").next();
		ImageWriteParam jpegWriteParam=jpegWriter.getDefaultWriteParam();
		jpegWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		jpegWriteParam.setCompressionQuality(compressionQuality);
		
		try(ImageOutputStream output=ImageIO.createImageOutputStream(compressedImage))
		{
			jpegWriter.setOutput(output);
			IIOImage outputImage=new IIOImage(image,null,null);
			jpegWriter.write(null,outputImage,jpegWriteParam);
			
			
		}
		jpegWriter.dispose();
	}

}

