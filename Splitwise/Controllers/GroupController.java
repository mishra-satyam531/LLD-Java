package Splitwise.Controllers;

import java.util.ArrayList;
import java.util.List;

import Splitwise.Models.Group;
import Splitwise.Models.User;

public class GroupController {
    private List<Group> groupList;

    public GroupController() {
        this.groupList = new ArrayList<>();
    }

    public void createGroup(String groupId, String groupName, User createdBy) {
        Group group = new Group(groupId, groupName);
        group.addMember(createdBy);
        groupList.add(group);
    }

    public Group getGroup(String groupId) {
        for (Group group : groupList) {
            if (group.getGroupId().equals(groupId)) {
                return group;
            }
        }
        return null;
    }

    public void addMemberToGroup(String groupId, User user) {
        Group group = getGroup(groupId);
        if (group != null) {
            group.addMember(user);
        } else {
            System.out.println("Group not found: " + groupId);
        }
    }
    
    public List<Group> getAllGroups() {
        return groupList;
    }
}
