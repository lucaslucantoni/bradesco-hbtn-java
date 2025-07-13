public class PersonagemGame {
    
    private int saudeAtual; 
    private String nome; 


    public void tomarDano(int quantidadeDeDano){

        int newSaudeAtual = saudeAtual - quantidadeDeDano;
        this.saudeAtual = newSaudeAtual < 0 ? 0 : newSaudeAtual;
    }

    public void receberCura (int quantidadeDeCura){

        int newSaudeAtual = saudeAtual + quantidadeDeCura;
        this.saudeAtual = newSaudeAtual > 100 ? 100 : newSaudeAtual;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getSaudeAtual(){
        return this.saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual){
        this.saudeAtual = saudeAtual;
    }

}
