package tests;

import ddswriter.cli.CLI109;

public class Test{
	public static void main(String[] _args) throws Exception {
		TestUtils.extractResources();
		String args[]=("--format S2TC_DXT1 --in "+TestUtils.tmpPath("texture2D_2.png")
		+" --out "+TestUtils.tmpPath("S2TC_DXT1.dds")).split(" ");
		CLI109.main(args);
	}
}