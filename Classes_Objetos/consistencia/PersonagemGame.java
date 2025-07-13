
public class PersonagemGame {
    
    private int saudeAtual; 
    private String nome; 
    private String status;

    public PersonagemGame(int saudeAtual, String nome){
        setSaudeAtual(saudeAtual);
        setNome(nome);
    }

    
    public void tomarDano(int quantidadeDeDano){

        int newSaudeAtual = saudeAtual - quantidadeDeDano;
        this.setSaudeAtual(newSaudeAtual < 0 ? 0 : newSaudeAtual);
    }

    public void receberCura (int quantidadeDeCura){

        int newSaudeAtual = saudeAtual + quantidadeDeCura;
        this.setSaudeAtual(newSaudeAtual > 100 ? 100 : newSaudeAtual);
    }

    public String getStatus(){
        return this.status;
    }

    public String getNome(){

        return this.nome;
    }
    public void setNome(String nome){
        if (nome != null && nome != ""){
            this.nome = nome;
        } 
    }

    public int getSaudeAtual(){
        return this.saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual){
        if (saudeAtual > 0) {
            status = "vivo";
        } else if (saudeAtual == 0){
            status = "morto";
        }
        this.saudeAtual = saudeAtual;
    }


}
