package test.project3;



/**
  *!@description:
  *@author: dong
  *@date: 2020-09-24 20:24:53
  *@version: V1.0.5
*/
public class TeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5; //限制开发团队人数
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;

    public TeamService(){

    }

    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for(int i = 0;i < team.length;i++){
            team[i] = this.team[i];
        }
        return team;
    }
    
    /**
     * 添加指定员工
     * 
     * @param e
     * @throws TeamException
     */
    public void addMember(Employee e) throws TeamException {
        if(total >= MAX_MEMBER){
            throw new TeamException("成员已满");
        }

        if(!(e instanceof Programmer)){
            throw new TeamException("非开发人员，无法添加");
        }

        if(isExist(e)){
            throw new TeamException("已经有了");
        }


        Programmer p = (Programmer)e;
        // if(p.getStatus().getNAME().equals("BUSY")){
        //     throw new TeamException("已经是某团对成员");
        // }else if("VOCATION".equals(p.getStatus().getNAME())){
        //     throw new TeamException("人在度假，无法添加");
        // }

        switch (p.getStatus()) {
            case FREE:
                throw new TeamException("该员工已经是某团队成员");
            case VOCATION:
            throw new TeamException("改成员正在休假，无法添加");
        }

        int numOfArch = 0,numofDes = 0, numofPro = 0;
        for(int i = 0;i < total;i++){
            if(team[i] instanceof Architect){
                numOfArch++;
            }else if(team[i] instanceof Designer){
                numofDes++;
            }else if(team[i] instanceof Programmer){
                numofPro++;
            }
        }

        if(p instanceof Architect){
            if(numOfArch >= 1){
                throw new TeamException("只能有一名架构师");
            }
        }else if(p instanceof Designer){
            if(numofDes >= 2){
                throw new TeamException("团队中已经有两名设计师");
            }
        }else if(p instanceof Programmer){
            if(numofPro >= 3){
                throw new TeamException("团队最多三名程序员");
            }
        }
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        team[total++] = p;      
    }
    private boolean isExist(Employee e) {
        for(int i = 0;i < total; i++){
            if(team[i].getId() == e.getId()){
                return true;
            }
        }
        return false;
    }
    public void removeMember(int memberId) throws TeamException {
        int i;
        for(i = 0;i < total;i++){
            if(team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i == total){
            throw new TeamException("成员未找到");
        }
        //删除后前移
        for(int j = i + 1;j < total;j++){
            team[j-1] = team[j];
        }
        team[--total] = null;
    }
}
