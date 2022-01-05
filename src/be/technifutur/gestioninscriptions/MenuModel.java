package be.technifutur.gestioninscriptions;

import java.util.ArrayList;

public class MenuModel {
        private ArrayList<MenuNode> menuNodeList = new ArrayList<>();
        String name;

        public MenuModel(String name) {
            this.name = name;
        }

        public void addNode(MenuNode menunode) {
            if (menunode != null) {
                this.menuNodeList.add(menunode);
            }
        }

        public MenuNode getNode(int pos) {
            MenuNode result = null;
            if (pos >= 0 && pos < menuNodeList.size())
            {
                result = menuNodeList.get(pos);
            }
            return result;
        }

        public String getName() {
            return this.name;
        }

        public int size() {
            return this.menuNodeList.size();
        }
}

