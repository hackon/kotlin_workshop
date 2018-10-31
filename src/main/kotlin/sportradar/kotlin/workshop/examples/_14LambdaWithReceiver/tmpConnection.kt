package sportradar.kotlin.workshop.examples._14LambdaWithReceiver

import java.io.Closeable
import java.sql.*
import java.util.*
import java.util.concurrent.Executor

class MyConnection : Connection {
  override fun setSavepoint(): Savepoint {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun setSavepoint(p0: String?): Savepoint {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getTypeMap(): MutableMap<String, Class<*>> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun clearWarnings() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getMetaData(): DatabaseMetaData {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getTransactionIsolation(): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun setSchema(p0: String?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getNetworkTimeout(): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun setTypeMap(p0: MutableMap<String, Class<*>>?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun createSQLXML(): SQLXML {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getWarnings(): SQLWarning {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getCatalog(): String {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun setHoldability(p0: Int) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getSchema(): String {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun isValid(p0: Int): Boolean {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun close() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun isClosed(): Boolean {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun createNClob(): NClob {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun createBlob(): Blob {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun createArrayOf(p0: String?, p1: Array<out Any>?): java.sql.Array {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun setReadOnly(p0: Boolean) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun isWrapperFor(p0: Class<*>?): Boolean {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun nativeSQL(p0: String?): String {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun createStruct(p0: String?, p1: Array<out Any>?): Struct {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun setClientInfo(p0: String?, p1: String?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun setClientInfo(p0: Properties?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun releaseSavepoint(p0: Savepoint?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun createClob(): Clob {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun isReadOnly(): Boolean {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun createStatement(): Statement {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun createStatement(p0: Int, p1: Int): Statement {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun createStatement(p0: Int, p1: Int, p2: Int): Statement {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun prepareStatement(p0: String?): PreparedStatement {
    return "" as PreparedStatement
  }

  override fun prepareStatement(p0: String?, p1: Int, p2: Int): PreparedStatement {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun prepareStatement(p0: String?, p1: Int, p2: Int, p3: Int): PreparedStatement {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun prepareStatement(p0: String?, p1: Int): PreparedStatement {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun prepareStatement(p0: String?, p1: IntArray?): PreparedStatement {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun prepareStatement(p0: String?, p1: Array<out String>?): PreparedStatement {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun rollback() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun rollback(p0: Savepoint?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getHoldability(): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun setNetworkTimeout(p0: Executor?, p1: Int) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun commit() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun <T : Any?> unwrap(p0: Class<T>?): T {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun setTransactionIsolation(p0: Int) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun setAutoCommit(p0: Boolean) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun abort(p0: Executor?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun prepareCall(p0: String?): CallableStatement {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun prepareCall(p0: String?, p1: Int, p2: Int): CallableStatement {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun prepareCall(p0: String?, p1: Int, p2: Int, p3: Int): CallableStatement {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getClientInfo(p0: String?): String {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getClientInfo(): Properties {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getAutoCommit(): Boolean {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun setCatalog(p0: String?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}