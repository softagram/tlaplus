/*******************************************************************************
 * Copyright (c) 2018 Microsoft Research. All rights reserved. 
 *
 * The MIT License (MIT)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy 
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software. 
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN
 * AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Contributors:
 *   Markus Alexander Kuppe - initial API and implementation
 ******************************************************************************/
package pcal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tlc2.output.EC;

public class RealQuicksortTest extends PCalModelCheckerTestCase {

	public RealQuicksortTest() {
		super("RealQuicksort", "pcal", new String[] {"-wf", "-termination"});
	}

	@Test
	public void testSpec() {
		assertTrue(recorder.recordedWithStringValue(EC.TLC_INIT_GENERATED1, "33"));
		assertTrue(recorder.recordedWithStringValues(EC.TLC_CHECKING_TEMPORAL_PROPS, "complete", "495"));
		assertTrue(recorder.recorded(EC.TLC_FINISHED));
		assertFalse(recorder.recorded(EC.GENERAL));
		assertTrue(recorder.recordedWithStringValues(EC.TLC_STATS, "706", "495", "0"));
		assertTrue(recorder.recordedWithStringValue(EC.TLC_SEARCH_DEPTH, "14"));

		assertCoverage("  line 100, col 32 to line 100, col 58 of module RealQuicksort: 0\n" +
			"  line 101, col 11 to line 101, col 16 of module RealQuicksort: 334\n" +
			"  line 104, col 12 to line 104, col 32 of module RealQuicksort: 180\n" +
			"  line 105, col 12 to line 105, col 22 of module RealQuicksort: 180\n" +
			"  line 106, col 22 to line 106, col 46 of module RealQuicksort: 0\n" +
			"  line 110, col 41 to line 110, col 44 of module RealQuicksort: 0\n" +
			"  line 71, col 18 to line 71, col 36 of module RealQuicksort: 144\n" +
			"  line 76, col 23 to line 76, col 29 of module RealQuicksort: 144\n" +
			"  line 77, col 23 to line 77, col 42 of module RealQuicksort: 144\n" +
			"  line 78, col 23 to line 78, col 46 of module RealQuicksort: 144\n" +
			"  line 79, col 23 to line 79, col 42 of module RealQuicksort: 144\n" +
			"  line 80, col 11 to line 80, col 20 of module RealQuicksort: 144\n" +
			"  line 87, col 27 to line 87, col 45 of module RealQuicksort: 319\n" +
			"  line 89, col 41 to line 89, col 52 of module RealQuicksort: 87\n" +
			"  line 90, col 41 to line 93, col 58 of module RealQuicksort: 87\n" +
			"  line 94, col 38 to line 94, col 48 of module RealQuicksort: 87\n" +
			"  line 95, col 38 to line 95, col 47 of module RealQuicksort: 87\n" +
			"  line 96, col 38 to line 96, col 46 of module RealQuicksort: 232\n" +
			"  line 97, col 38 to line 97, col 49 of module RealQuicksort: 232\n" +
			"  line 98, col 48 to line 98, col 64 of module RealQuicksort: 0\n" +
			"  line 99, col 22 to line 99, col 33 of module RealQuicksort: 15");
	}
}
/*
C:\lamport\tla\pluscal>java -mx1000m -cp "c:/lamport/tla/newtools/tla2-inria-workspace/tla2-inria/tlatools/class" tlc2.TLC -cleanup RealQuicksort.tla         
TLC2 Version 2.05 of 18 May 2012
Running in Model-Checking mode.
Parsing file RealQuicksort.tla
Parsing file C:\lamport\tla\newtools\tla2-inria-workspace\tla2-inria\tlatools\class\tla2sany\StandardModules\Naturals.tla
Parsing file C:\lamport\tla\newtools\tla2-inria-workspace\tla2-inria\tlatools\class\tla2sany\StandardModules\Sequences.tla
Parsing file C:\lamport\tla\newtools\tla2-inria-workspace\tla2-inria\tlatools\class\tla2sany\StandardModules\FiniteSets.tla
Semantic processing of module Naturals
Semantic processing of module Sequences
Semantic processing of module FiniteSets
Semantic processing of module RealQuicksort
Starting... (2012-08-10 17:38:31)
Implied-temporal checking--satisfiability problem has 1 branches.
Computing initial states...
Finished computing initial states: 33 distinct states generated.
Checking temporal properties for the complete state space...
Model checking completed. No error has been found.
  Estimates of the probability that TLC did not check all reachable states
  because two distinct states had the same fingerprint:
  calculated (optimistic):  val = 5.7E-15
  based on the actual fingerprints:  val = 2.7E-15
706 states generated, 495 distinct states found, 0 states left on queue.
The depth of the complete state graph search is 14.
Finished. (2012-08-10 17:38:32)
*/