package com.codebase.designpatrens.strategy;

import java.io.File;
import java.util.ArrayList;

public class CompressionContext {
	private CompressionStrategy strategy;

	// this can be set at runtime by the application preferences
	public void setCompressionStrategy(CompressionStrategy strategy) {
		this.strategy = strategy;
	}

	// use the strategy
	public void createArchive(ArrayList<File> files) {
		strategy.compressFiles(files);
	}

	public static void main(String[] args) {
		CompressionContext ctx = new CompressionContext();
		// we could assume context is already set by preferences
		ctx.setCompressionStrategy(new ZipCompressionStrategy());
		ArrayList<File> fileList = null;
		// get a list of files...
		ctx.createArchive(fileList);
	}

}