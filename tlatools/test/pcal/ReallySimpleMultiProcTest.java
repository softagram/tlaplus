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

public class ReallySimpleMultiProcTest extends PCalModelCheckerTestCase {

	public ReallySimpleMultiProcTest() {
		super("ReallySimpleMultiProc", "pcal", new String[] {"-wf", "-termination"});
	}

	@Test
	public void testSpec() {
		assertTrue(recorder.recordedWithStringValue(EC.TLC_INIT_GENERATED1, "4"));
		assertTrue(recorder.recordedWithStringValues(EC.TLC_CHECKING_TEMPORAL_PROPS, "complete", "76"));
		assertTrue(recorder.recorded(EC.TLC_FINISHED));
		assertFalse(recorder.recorded(EC.GENERAL));
		assertTrue(recorder.recordedWithStringValues(EC.TLC_STATS, "144", "76", "0"));
		assertTrue(recorder.recordedWithStringValue(EC.TLC_SEARCH_DEPTH, "7"));

	assertCoverage("  line 49, col 13 to line 49, col 38 of module ReallySimpleMultiProc: 36\n" +
		"  line 50, col 13 to line 50, col 37 of module ReallySimpleMultiProc: 36\n" +
		"  line 51, col 10 to line 51, col 39 of module ReallySimpleMultiProc: 36\n" +
		"  line 52, col 20 to line 52, col 32 of module ReallySimpleMultiProc: 0\n" +
		"  line 57, col 10 to line 57, col 41 of module ReallySimpleMultiProc: 4\n" +
		"  line 58, col 20 to line 58, col 43 of module ReallySimpleMultiProc: 0\n" +
		"  line 63, col 16 to line 63, col 48 of module ReallySimpleMultiProc: 48\n" +
		"  line 64, col 16 to line 64, col 47 of module ReallySimpleMultiProc: 48\n" +
		"  line 65, col 26 to line 65, col 44 of module ReallySimpleMultiProc: 0\n" +
		"  line 68, col 16 to line 68, col 43 of module ReallySimpleMultiProc: 48\n" +
		"  line 69, col 16 to line 69, col 49 of module ReallySimpleMultiProc: 48\n" +
		"  line 70, col 26 to line 70, col 43 of module ReallySimpleMultiProc: 0\n" +
		"  line 77, col 70 to line 77, col 73 of module ReallySimpleMultiProc: 0");
	}
}
