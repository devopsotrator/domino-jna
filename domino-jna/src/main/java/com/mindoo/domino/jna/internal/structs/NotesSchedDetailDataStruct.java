package com.mindoo.domino.jna.internal.structs;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.List;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class NotesSchedDetailDataStruct extends BaseStructure {
	/** Notes data type for the data */
	public short wType;
	/** Length of the data that immediately follows */
	public short wDataLen;
	/** SCHED_DETAIL_DATA_ATTR_xxx attributes */
	public byte Attr;
	/** Reserved space/padding for ODS */
	public byte bReserved;
	
	public NotesSchedDetailDataStruct() {
		super();
	}
	
	public static NotesSchedDetailDataStruct newInstance() {
		return AccessController.doPrivileged(new PrivilegedAction<NotesSchedDetailDataStruct>() {

			@Override
			public NotesSchedDetailDataStruct run() {
				return new NotesSchedDetailDataStruct();
			}
		});
	}
	
	protected List<String> getFieldOrder() {
		return Arrays.asList("wType", "wDataLen", "Attr", "bReserved");
	}
	/**
	 * @param wType Notes data type for the data<br>
	 * @param wDataLen Length of the data that immediately follows<br>
	 * @param Attr SCHED_DETAIL_DATA_ATTR_xxx attributes<br>
	 * @param bReserved Reserved space/padding for ODS
	 */
	public NotesSchedDetailDataStruct(short wType, short wDataLen, byte Attr, byte bReserved) {
		super();
		this.wType = wType;
		this.wDataLen = wDataLen;
		this.Attr = Attr;
		this.bReserved = bReserved;
	}
	
	public static NotesSchedDetailDataStruct newInstance(final short wType, final short wDataLen,
			final byte Attr, final byte bReserved) {
		return AccessController.doPrivileged(new PrivilegedAction<NotesSchedDetailDataStruct>() {

			@Override
			public NotesSchedDetailDataStruct run() {
				return new NotesSchedDetailDataStruct(wType, wDataLen, Attr, bReserved);
			}
		});
	}

	public NotesSchedDetailDataStruct(Pointer peer) {
		super(peer);
	}
	
	public static NotesSchedDetailDataStruct newInstance(final Pointer peer) {
		return AccessController.doPrivileged(new PrivilegedAction<NotesSchedDetailDataStruct>() {

			@Override
			public NotesSchedDetailDataStruct run() {
				return new NotesSchedDetailDataStruct(peer);
			}
		});
	}

	public static class ByReference extends NotesSchedDetailDataStruct implements Structure.ByReference {
		
	};
	public static class ByValue extends NotesSchedDetailDataStruct implements Structure.ByValue {
		
	};
}