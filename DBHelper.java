public class DBHelper{
	private static final String DATABASE_NAME="projetofinal.db";
	private static final String DATABASE_VERSION=1;
	private static final String TABLE_NAME="cadastro";
	
	private Context context;
	private SQLiteDatabase db;
	
	private SQLite Statement insertStmt;
	private static final String INSERT="insert into" + TABLE_NAME+ "(nome,cpf,idade, telefone, email) values(?,?,?,?,?)";
	
	public DBHelper(Context context){
		 this.content=content;
		 OperHelper openHelper= new OpenHelper(this.context);
		 this.db= openHelper.getWritableDatabase();
		 this.insertStmt= this.db.compileStatement(INSERT);	
	}
	
	public long insert(String nome,String cpf,String idade, String telefone, String email){
		this.insertStmt.bindString(1, nome);
		this.insertStmt.bindString(2, cpf);
		this.insertStmt.bindString(3, idade);
		this.insertStmt.bindString(4, telefone);
		this.insertStmt.bindString(5, email);
		return this.insertStmt.executeInsert();
	}
	
	public void deletarTudo(){
		thi.db.delete(TABLE_NAME,null,null)
		
	}
	
	public List<Cpf> queryGetAll(){
		List<Cpf> List= new ArrayList<Cpf>();
		
		try{
			Cursor cursor=this.db.query(TABLE_NAME, new String []{"nome","cpf","idade","telefone","email"},
			null,null,null,null,null,null);
			int nregistros=cursor.getCount();
			if(nregistros!=0){
				cursor.moveToFirst();
				do{
					Cpf cpf= new Cpf(cursorGetString[0],cursorGetString[1],cursorGetString[2],cursorGetString[3],cursorGetString[4]);
					list.add(cpf); 
				}while(cursor.moveToNext());
				if(cursor !=null && ! cursor.isClosed())
					cursor.close();
					return list;
			}else
				return null;
		}
		catch (Exception err){
			return null;
		}
	}
	
	private static class OpenHelper extends SQLiteOpenHelper{
		OpenHelper(Context context){
			super(context,DATABASE_NAME,null,DATABASE_VERSION);
		}
		public void onCreate(SQLiteDatabase db){
			String sql="CREATE TABLE IF NOT EXISTS " + TABLE_NAME +"(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT,cpf INTEGER, idade INTEGER,telefone NUMBER,email TEXT);";
			db.execSQL(sql);
		}
		public void onUpdate(SQLiteDatabase,int oldVersion,int newVersion){
			db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
			onCreate(db);
		}
	}
}