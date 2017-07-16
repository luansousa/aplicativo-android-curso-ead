public class Cpf{
	
	private String nome; 
	private int cpf;	
	private String idade;
	private String telefone;
	private String email;
	
	
	Cpf(String nome,String cpf,String idade, String telefone, String email){ //construtor
		this.nome=nome;
		this.cpf=cpf;
		this.idade=idade;
		this.telefone=telefone;
		this.email=email;
		
	}
	
	
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	
	
	public String getCpf(){
		return cpf;
	}
	public void setCpf(String cpf){
		this.cpf=cpf;
	}
	
	
	public String getIdade(){
		return idade;
	}
	public void setIdade(String Idade){
		this.idade=idade;
	}
	
	public String getTelefone(){
		return telefone;
	}
	public void setTelefone(String telefone){
		this.telefone=telefone;
	}
	
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	
	
	
	
	
	
	
	
}