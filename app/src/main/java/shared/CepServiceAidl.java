/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\marco\\AndroidStudioProjects\\AtividadeService\\clientapp\\src\\main\\aidl\\shared\\CepServiceAidl.aidl
 */
package shared;
// Declare any non-default types here with import statements

public interface CepServiceAidl extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements shared.CepServiceAidl
{
private static final java.lang.String DESCRIPTOR = "shared.CepServiceAidl";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an shared.CepServiceAidl interface,
 * generating a proxy if needed.
 */
public static shared.CepServiceAidl asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof shared.CepServiceAidl))) {
return ((shared.CepServiceAidl)iin);
}
return new shared.CepServiceAidl.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getInformation:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.Map _result = this.getInformation(_arg0);
reply.writeNoException();
reply.writeMap(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements shared.CepServiceAidl
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     **/
@Override public java.util.Map getInformation(java.lang.String cep) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.Map _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(cep);
mRemote.transact(Stub.TRANSACTION_getInformation, _data, _reply, 0);
_reply.readException();
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_result = _reply.readHashMap(cl);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getInformation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     **/
public java.util.Map getInformation(java.lang.String cep) throws android.os.RemoteException;
}
