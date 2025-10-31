package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public void contratar(Desenvolvedor desenvolvedor){
        if(desenvolvedores.size() < vagas){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double totalSalarios = 0.0;
        for(Desenvolvedor desenvolvedor : desenvolvedores){
            totalSalarios+=desenvolvedor.calcularSalario();
        }

        return totalSalarios;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer qtdDesenvolvedoresMob = 0;
        for(Desenvolvedor desenvolvedor : desenvolvedores){
            if(desenvolvedor instanceof DesenvolvedorMobile){
                qtdDesenvolvedoresMob++;
            }
        }

        return qtdDesenvolvedoresMob;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> desenvolvedoresSalarioMaiorQue = new ArrayList<>();

        for(Desenvolvedor devs : desenvolvedores){
            if(devs.calcularSalario() >= salario){
                desenvolvedoresSalarioMaiorQue.add(devs);
            }
        }

        return desenvolvedoresSalarioMaiorQue;
    }

    public Desenvolvedor buscarMenorSalario(){
        if(desenvolvedores.isEmpty()){
            return null;
        }

        Desenvolvedor devMenorSalario = desenvolvedores.get(0);

        for(Desenvolvedor dev : desenvolvedores){
            if(dev.calcularSalario() <= devMenorSalario.calcularSalario()){
                devMenorSalario = dev;
            }
        }

        return devMenorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> devTech = new ArrayList<>();

        for(Desenvolvedor dev : desenvolvedores){
            if(dev instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) dev).getLinguagem().equalsIgnoreCase(tecnologia) ||
                        ((DesenvolvedorMobile) dev).getPlataforma().equalsIgnoreCase(tecnologia)){
                    devTech.add(dev);
                }
            }else if(dev instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) dev).getBackend().equalsIgnoreCase(tecnologia) ||
                ((DesenvolvedorWeb) dev).getFrontend().equalsIgnoreCase(tecnologia) ||
                ((DesenvolvedorWeb) dev).getSgbd().equalsIgnoreCase(tecnologia)){
                    devTech.add(dev);
                }
            }
        }

        return devTech;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        List<Desenvolvedor> devsPorTech = buscarPorTecnologia(tecnologia);

        Double salarioPorTech = 0.0;
        for(Desenvolvedor dev : devsPorTech){
            salarioPorTech+=dev.calcularSalario();
        }

        return salarioPorTech;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }
}
