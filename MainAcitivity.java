public class MainAcitivity extends AppCompatActivity{
	
	
	Button btSegundaTela;
	
	
	protected void onCreate(Bundle savedInstanceState){ //aqui vão os codigos para iniciar os atributos do layout
		super.onCreate();
		setContentView();
		
		
		
		btSegundaTela=(Button) findViewById(R.id.btnvoltar);
		
		btInserir.setOnClickListener(new View.OnclickListener()){
			public void onClick(View v){
				vaiSegundaTela():
			}
			
		}
		
		
		
	} 

	void vaiSegundaTela(){
		Intent intent= new Intent():
		intent.setClass(MainAcitivity.this, SecondActivity.class);
		startAcitivity(intent);
		finish();
		
	}





}