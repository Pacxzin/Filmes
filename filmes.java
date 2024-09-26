public class filme {
    private String titulo; // Título do filme
    private int duracao;   // Duração em minutos
    private String genero;  // Gênero do filme

    // Construtor da classe Filme
    public filme(String titulo, int duracao, String genero) {
        setTitulo(titulo);
        setDuracao(duracao);
        setGenero(genero);
    }

    // Método para obter o título
    public String getTitulo() {
        return titulo;
    }

    // Método para definir o título com validação
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode estar vazio.");
        }
        this.titulo = titulo;
    }

    // Método para obter a duração
    public int getDuracao() {
        return duracao;
    }

    // Método para definir a duração com validação
    public void setDuracao(int duracao) {
        if (duracao <= 0) {
            throw new IllegalArgumentException("A duração deve ser maior que zero.");
        }
        this.duracao = duracao;
    }

    // Método para obter o gênero
    public String getGenero() {
        return genero;
    }

    // Método para definir o gênero com validação
    public void setGenero(String genero) {
        if (!isGeneroValido(genero)) {
            throw new IllegalArgumentException("O gênero deve ser 'Romance', 'Terror' ou 'Comédia'.");
        }
        this.genero = genero;
    }

    // Método para verificar se o gênero é válido
    private boolean isGeneroValido(String genero) {
        return "Romance".equalsIgnoreCase(genero) ||
               "Terror".equalsIgnoreCase(genero) ||
               "Comédia".equalsIgnoreCase(genero);
    }

    // Método para mostrar infos do filme
    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", duracao=" + duracao +
                " minutos, genero='" + genero + '\'' +
                '}';
    }

    // Método main para testar a classe Filme
    public static void main(String[] args) {
        try {
            filme filme1 = new filme("O Grande Gatsby", 120, "Romance");
            System.out.println(filme1);

            filme filme2 = new filme("It: A Coisa", 150, "Terror");
            System.out.println(filme2);

            // Testando exceções
            // Filme filmeInvalido = new Filme("", 90, "Comédia"); // Título vazio
            // Filme filmeInvalido2 = new Filme("Apertem os Cintos", 0, "Comédia"); // Duração inválida
            // Filme filmeInvalido3 = new Filme("Um Filme Qualquer", 90, "Ação"); // Gênero inválido

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}