import { MenuRootItem } from 'ontimize-web-ngx';

export const MENU_CONFIG: MenuRootItem[] = [
  { id: 'home', name: 'HOME', icon: 'home', route: '/main/home' },
  { id: 'locationsbasic', name: 'LOCATIONS BASIC', icon: 'home', route: '/main/locations' },
  { id: 'locationsmodal', name: 'LOCATIONS MODAL', icon: 'home', route: '/main/locationsmodal' },
  { id: 'locationstab', name: 'LOCATIONS TAB', icon: 'home', route: '/main/locationstab' },
  { id: 'locationssplit', name: 'LOCATIONS SPLIT', icon: 'home', route: '/main/locationssplit' },
  { id: 'locationsdata', name: 'LOCATIONS DATA', icon: 'home', route: '/main/locationsdata' },
  { id: 'tags', name: 'TAGS', icon: 'home', route: '/main/tags' },
  { id: 'locationtags', name: 'LOCATION TAGS', icon: 'home', route: '/main/locationtags' },
  {
    id: 'admin', name: 'ADMIN', tooltip: 'ADMIN', icon: 'admin_panel_settings',
    items: [
      { id: 'roles', name: 'ROLES', tooltip: 'ROLES', route: '/main/admin/roles', icon: 'supervisor_account' },
      { id: 'users', name: 'USERS', tooltip: 'USERS', route: '/main/admin/users', icon: 'person' },
    ]
  },
  { id: 'logout', name: 'LOGOUT', route: '/login', icon: 'power_settings_new', confirm: 'yes' }
];
