package com.ibrahimatay;

// JEP 458: Launch Multi-File Source-Code Programs
// https://openjdk.org/jeps/458

// JEP draft: Launch Multi-File Source-Code Programs
// https://www.reddit.com/r/java/comments/11u1w17/jep_draft_launch_multifile_sourcecode_programs/

// java --enable-preview --source 22 JEP458LaunchMultiFileSourceCode.java

public class JEP458LaunchMultiFileSourceCode {
	static {
		System.out.println("LaunchMultiFileSourceCodeProgramMain static initializer");
	}

	void main() {
		System.out.println("Here the launcher will compile and load the other Java file");
		var value = LaunchMultiFileSourceCodeHelper.generateValue();
		System.out.println("Value: " + value);
	}
}

class LaunchMultiFileSourceCodeHelper {
	static {
		System.out.println("LaunchMultiFileHelper static initializer");
	}

	public static int generateValue() {
		return 42;
	}
}