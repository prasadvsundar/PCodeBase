package com.codebase.designpatrens.strategy;

import java.io.File;
import java.util.ArrayList;

//Strategy Interface
public interface CompressionStrategy {
	public void compressFiles(ArrayList<File> files);
}