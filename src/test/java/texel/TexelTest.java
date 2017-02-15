package texel;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jme3.math.Vector4f;

import ddswriter.delegators.s2tc.Texel;
import ddswriter.delegators.s2tc.Texel.PixelFormat;

public class TexelTest{
	
	@Test 
	public void testConversion(){
		Vector4f pixels[][]=new Vector4f[2][2];
		pixels[0][0]=new Vector4f(11,11,11,11);pixels[1][0]=new Vector4f(22,22,22,22);
		pixels[0][1]=new Vector4f(255,255,255,255);pixels[1][1]=new Vector4f(1,1,1,1);
		for(Vector4f pxs[]:pixels){
			for(Vector4f px:pxs){
				System.out.println(px);
			}
		}

		Texel texel=new Texel(PixelFormat.RGBA8_INT,pixels);

		Vector4f pixel1=texel.get(PixelFormat.RGBA8_FLOAT,0,0);
		Vector4f pixel2=new Vector4f(11f/255,11f/255,11f/255,11f/255);
		assertTrue("RGBA8_INT 2 RGBA8_FLOAT: "+pixel1+" != "+pixel2,pixel1.equals(pixel2));

		pixel1=texel.get(PixelFormat.RGBA8_INT,0,0);
		pixel2=texel.get(PixelFormat.RGBA5658_INT,0,0);
		assertTrue("RGBA8_INT 2 RGBA5658_INT: "+pixel1+" != "+pixel2,pixel1.equals(pixel2));
		
		pixel1=texel.get(PixelFormat.RGBA8_INT,0,1);
		pixel2=texel.get(PixelFormat.RGBA5658_INT,0,1);
		assertTrue("RGBA8_INT 2 RGBA5658_INT  -OUT range: "+pixel1+" == "+pixel2,!pixel1.equals(pixel2));
	}

}