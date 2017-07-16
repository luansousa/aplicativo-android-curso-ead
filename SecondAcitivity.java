public class MainAcitivity extends AppCompatActivity{
	
	private DBHelper dh;

	EditText etNome,etCpf,etIdade,etTelefone,etEmail;
	Button btInserir,btListar,btVoltar;
	
	
	protected void onCreate(Bundle savedInstanceState){ //aqui vão os codigos para iniciar os atributos do layout
		super.onCreate();
		setContentView();
		
		this.dh=new DBHelper(this);
		
		etNome=(EditText) findViewById(R.id.etnome);
		etCpf=(EditText) findViewById(R.id.etcpf);
		etIdade=(EditText) findViewById(R.id.etidade);
		etTelefone=(EditText) findViewById(R.id.ettelefone);
		etEmail=(EditText) findViewById(R.id.etemail);
		btInserir=(Button) findViewById(R.id.btninserir);
		btListar=(Button) findViewById(R.id.btnlistar);
		btVoltar=(Button) findViewById(R.id.btnvoltar);
		
		btInserir.setOnClickListener(new View.OnclickListener()){
			@override
			public void onClick(View v){
				if(etNome.getText.length>0 && etCpf.getText.length>0 && etIdade.getText.length>0 && etTelefone.getText.length>0 && etEmail.getText.length>0 ){
					dh.insert(etNome.getText().toString(), etCpf.getText().toString(),etIdade.getText().toString(),etTelefone.getText().toString(),etEmail.getText().toString());
					
					AlertDialog.Builder adb= new AlertDialog.Builder(SecondActivity.this);
					adb.setTitle("Sucesso");
					adb.setMessage("Cadastro realizado com sucesso!!!");
					adb.show();
					
					etNome.setText("");
					etCpf.setText("");
					etIdade.setText("");
					etTelefone.setText("");
					etEmail.setText("");
					
				}else{
					AlertDialog.Builder adb= new AlertDialog.Builder(SecondActivity.this);
					adb.setTitle("Erro!!");
					adb.setMessage("Todos os campos devem ser preenchidos.");
					adb.show();
					
					etNome.setText("");
					etCpf.setText("");
					etIdade.setText("");
					etTelefone.setText("");
					etEmail.setText("");
					
				}
			}
			
		}
		
		btInserir.setOnClickListener(new View.OnclickListener()){
			@override
			public void onClick(View v){
				List <Cpf> cpfs=dh.queryGetAll();
				if(cpfs==null){
					AlertDialog.Builder adb= new AlertDialog.Builder(SecondActivity.this);
					adb.setTitle("Mensagem");
					adb.setMessage("Não há registros cadastrados.");
					adb.show();
					return;
				}
				for(int i=0;i<cpfs.size();i++){
					Cpf cpf=(Cpf) cpfs.get(i);
					AlertDialog.Builder adb= new AlertDialog.Builder(SecondActivity.this);
					adb.setTitle("Registro" i);
					adb.setMessage("Nome:" +cpf.getNome()+"\nCpf:"+cpf.getCpf()+"\nIdade:"+cpf.getIdade()+"\nTelefone:"+cpf.getTelefone()+"\nEmail:"+cpf.getEmail());
					adb.setPositiveButton("OK", new DialogInterface.onClickListener(){
						@override
						public void onClick(DialogInterface dialog, int which ){
							dialog.dismise();
						}
					});
					adb.show();
				}
			}
			
		}
		
		btVoltar.setOnClickListener(new View.OnclickListener()){
			@override
			public void onClick(View v){
				voltaPrimeiraTela();
			}
			
		}
		
		void voltaPrimeiraTela(){
			Intent intent= new Intent():
			intent.setClass(SecondActivity.this, MainAcitivity.class);
			startAcitivity(intent);
			finish();
		}
		
	} 

