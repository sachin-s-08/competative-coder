/**
 * 
 */
package com.practice.tutorial.Tutorial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author ss
 *
 */
@BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
public class PerformanceBenchmark {
	
	public static void main(String[] args) throws Exception {
	    Options options = new OptionsBuilder()
	      .include(PerformanceBenchmark.class.getSimpleName())
	      .forks(1).build();
	    new Runner(options).run();
	}
	
	@State(Scope.Benchmark)
	public static class ExecutionPlan {
//		private Set<String> employeeSet = new HashSet<>();
        private List<String> employeeList = new ArrayList<>();
        
        private long iterations = 1000;
		
		  @Setup(Level.Trial)
		    public void invoke() {
			  for (long i = 0; i < iterations; i++) {
//	                employeeSet.add(String.valueOf(i));
	                employeeList.add(String.valueOf(i));
	            }
		    }
	}
	
	
	
	@Benchmark
	public boolean testHashSet(ExecutionPlan state) {
	    return (new HashSet<String>(state.employeeList)).contains("100");
	}
	
	@Benchmark
	public boolean testHashSet1(ExecutionPlan state) {
	    return state.employeeList.contains("100");
	}
	

}
