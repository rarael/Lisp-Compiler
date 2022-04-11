package a5;

import grader.basics.execution.BasicProjectExecution;
import gradingTools.comp524f21.assignment6.F21Assignment6Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
public class LocalChecks {
	public static void main(String[] args) {
	    final int sixHundred = 600;
	    final int twoThousand = 2000;
	    final int five = 5;
	    
		// if you set this to false, grader steps will not be traced
	    GraderBasicsTraceUtility.setTracerShowInfo(true);	
		// if you set this to false, all grader steps will be traced,
		// not just the ones that failed		
		GraderBasicsTraceUtility.setBufferTracedMessages(true);
		// Change this number if a test trace gets longer than 600 and is clipped
		GraderBasicsTraceUtility.setMaxPrintedTraces(sixHundred);
		// Change this number if all traces together are longer than 2000
		GraderBasicsTraceUtility.setMaxTraces(twoThousand);
		// Change this number if your process times out prematurely
		BasicProjectExecution.setProcessTimeOut(five);
		// You need to always call such a method
		F21Assignment6Suite.main(args);
	}
}
