enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel : Nivel) {
    val inscritos = mutableListOf<Usuario>()


    fun matricula(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }
}

fun main() {
    //Declaração de Usuarios
    val matheus = Usuario("Matheus")
    val xavier = Usuario("Xavier")
    val silva = Usuario("Silva")

    //Declaração de conteudos educacionais
    val kotlin = listOf(
        ConteudoEducacional("introdução ao kotlin", 120),
        ConteudoEducacional("POO com Kotlin", 180),
        ConteudoEducacional("desafios kotlin", 60)
    )
    val java = listOf(
        ConteudoEducacional("introdução ao Java", 120),
        ConteudoEducacional("POO com Java", 180),
        ConteudoEducacional("desafios Java", 60)
    )

    //Declaração de formações
    val formacaoKotlin = Formacao("Formação em Kotliin", kotlin, Nivel.INTERMEDIARIO)
    val formacaoJava = Formacao("Formação em Java", java, Nivel.INTERMEDIARIO)

    //Adicionando alunos nas formações
    formacaoKotlin.matricula(matheus, xavier)
    formacaoJava.matricula(xavier, silva)


    //imprimindo o nome dos inscritos
    println("Alunos da trilha Kotlin: ${formacaoKotlin.inscritos.joinToString { it.nome }}")
    println("Alunos da trilha Java: ${formacaoJava.inscritos.joinToString { it.nome }}")
}