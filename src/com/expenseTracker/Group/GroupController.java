package com.expenseTracker.Group;

import com.expenseTracker.User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groupList;

    public GroupController(){
        groupList=new ArrayList<>();
    }

    public void createNewGroup(String groupId, String groupName, User createdBy){

        //create a new group instance
        Group group=new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);

        group.addMember(createdBy);

        groupList.add(group);
    }

    public Group getGroup(String groupId){
        for(Group group: groupList){
            if(group.getGroupId().equals(groupId))return group;
        }
        return null;
    }
}
