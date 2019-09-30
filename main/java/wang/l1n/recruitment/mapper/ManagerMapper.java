package wang.l1n.recruitment.mapper;

import org.apache.ibatis.annotations.Mapper;
import wang.l1n.recruitment.entity.Manager;

import java.util.List;

@Mapper
public interface ManagerMapper {
    Manager selectManagerByUsername(String username);

    int insertManager(Manager manager);

    void addManagerToRole(int mid, int rid);

    List<Manager> getManagerList();

    Manager getManagerById(int mid);

    void updateManagerById(Manager manager);

    void deleteManager(String id);

    void deleteManagerFromRole(String id);
}
