import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static class Aluno {
        private String nome;
        private int matricula;
        private int ciclo;

        public Aluno(String nome, int matricula, int ciclo) {
            this.nome = nome;
            this.matricula = matricula;
            this.ciclo = ciclo;
        }

        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }
        
        public int getMatricula() { return matricula; }
        public void setMatricula(int matricula) { this.matricula = matricula; }
        
        public int getCiclo() { return ciclo; }
        public void setCiclo(int ciclo) { this.ciclo = ciclo; }

        @Override
        public String toString() {
            return "Aluno [Nome=" + nome + ", Matrícula=" + matricula + ", Ciclo=" + ciclo + "]";
        }
    }

    public static class AlunoController {
        private List<Aluno> listaAlunos;

        public AlunoController() {
            this.listaAlunos = new ArrayList<>();
        }

        public void adicionarAluno(Aluno aluno) {
            listaAlunos.add(aluno);
        }

        public List<Aluno> getListaAlunos() {
            return listaAlunos;
        }

        public boolean removerAlunoPorIndice(int indice) {
            if (indice >= 0 && indice < listaAlunos.size()) {
                listaAlunos.remove(indice);
                return true;
            }
            return false;
        }

        public int localizarIndicePorMatricula(int matricula) {
            for (int i = 0; i < listaAlunos.size(); i++) {
                if (listaAlunos.get(i).getMatricula() == matricula) {
                    return i;
                }
            }
            return -1;
        }

        public void limparLista() {
            listaAlunos.clear();
        }

        public void viradaDeSemestre() {
            for (Aluno aluno : listaAlunos) {
                aluno.setCiclo(aluno.getCiclo() + 1);
            }
        }
    }

    public static void main(String[] args) {
        AlunoController controller = new AlunoController();

        controller.adicionarAluno(new Aluno("Ana Silva", 101, 1));
        controller.adicionarAluno(new Aluno("Bruno Souza", 102, 2));

        System.out.println("--- Alunos Cadastrados ---");
        for (Aluno a : controller.getListaAlunos()) {
            System.out.println(a);
        }

        int indice = controller.localizarIndicePorMatricula(102);
        System.out.println("\nAluno com matrícula 102 encontrado no índice: " + indice);

        controller.viradaDeSemestre();
        System.out.println("\n--- Após Virada de Semestre ---");
        for (Aluno a : controller.getListaAlunos()) {
            System.out.println(a);
        }

        controller.removerAlunoPorIndice(0);
        System.out.println("\n--- Após Remover o Primeiro Aluno ---");
        for (Aluno a : controller.getListaAlunos()) {
            System.out.println(a);
        }

        controller.limparLista();
        System.out.println("\n--- Após Limpar a Lista ---");
        System.out.println("Quantidade de alunos: " + controller.getListaAlunos().size());
    }
}