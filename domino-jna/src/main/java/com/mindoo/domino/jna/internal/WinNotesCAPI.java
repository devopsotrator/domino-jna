package com.mindoo.domino.jna.internal;

import com.sun.jna.win32.StdCallLibrary;

/**
 * Extension of {@link NotesCAPI} implementing {@link StdCallLibrary} required
 * on Windows platforms
 * 
 * @author Karsten Lehmann
 */
public interface WinNotesCAPI extends NotesCAPI, StdCallLibrary {

	public interface b32_NsfSearchProcWin extends b32_NsfSearchProc, StdCallCallback { /* StdCallCallback if using __stdcall__ */
    }
	
	public interface b64_NsfSearchProcWin extends b64_NsfSearchProc, StdCallCallback { /* StdCallCallback if using __stdcall__ */
    }

}