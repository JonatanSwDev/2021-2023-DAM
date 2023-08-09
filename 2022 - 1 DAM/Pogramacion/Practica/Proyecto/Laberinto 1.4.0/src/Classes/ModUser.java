package Classes;

public class ModUser {

	public static void chPassword(User user) {
		String value = Interface.getString("Nueva contraseña\n (vacio para cancelar):\n ");
		if (value.isEmpty()) {
			System.err.println("Retrocediendo...");
			return;
		} else {
			// Validate USERNAME
			if (!Utils.validatePassword(value)) {
				System.err.println("Contraseña no válida valido");
				return;
			} else {
				String value2 = Interface.getString("Repite la contraseña: ");
				if (value.equals(value2)) {
					// Se escribe en la base de datos
					if (Database.modifyUser(user.id, "password", Utils.encryptMd5(value))) {
						System.out.println("Contraseña modificada correctamente");
					}
				} else {
					System.err.println("Las contraseñas no coinciden");
				}
			}
		}
	}

	public static void chName(User user) {
		String value = Interface.getString("Nuevo nombre\n (vacio para cancelar):\n");
		if (value.isEmpty()) {
			System.err.println("Retrocediendo...");
			return;
		} else {
			// Validate NAME
			if (!Utils.validateName(value)) {
				System.err.println("Nombre no valido");
				return;
			} else {
				if (Database.modifyUser(user.id, "name", value)) {
					System.out.println("Nombre modificado correctamente");
				}
			}
		}
	}

	public static void chNif(User user) {
		String value = Interface.getString("Nuevo NIF\n (vacio para cancelar):\n");
		if (value.isEmpty()) {
			System.err.println("Retrocediendo...");
			return;
		} else {
			// Validate NAME
			if (!Utils.validateNif(value)) {
				System.err.println("Formato no valido");
				return;
				// Check NIF
			} else if (Database.checkUser(value)) {
				System.err.println("Ya existe un usuario con ese NIF");
				return;
			} else {
				if (Database.modifyUser(user.id, "nif", value)) {
					System.out.println("NIF modificado correctamente");
				}
			}
		}
	}

	public static void chEmail(User user) {
		String value = Interface.getString("Nuevo email\n (vacio para cancelar):\n");
		if (value.isEmpty()) {
			System.err.println("Retrocediendo...");
			return;
		} else {
			// Validate EMAIL
			if (!Utils.validateEmail(value)) {
				System.err.println("Formato no valido");
				return;
				// Check EMAIL
			} else if (Database.checkUser(value)) {
				System.err.println("Ya existe un usuario con ese email");
				return;
			} else {
				// Se escribe en la base de datos
				if (Database.modifyUser(user.id, "email", value)) {
					System.out.println("Email modificado correctamente");
				}
			}
		}
	}

	public static void chDirection(User user) {
		String value = Interface.getString("Nueva direccion completa\n (vacio para cancelar):\n");
		if (value.isEmpty()) {
			System.err.println("Retrocediendo...");
			return;
		} else {
			// Se escribe en la base de datos
			if (Database.modifyUser(user.id, "address", value)) {
				System.out.println("Direccion modificada correctamente");
			}
		}
	}

	public static void chBirthDate(User user) {
		String value = Interface.getString("Nueva fecha de nacimiento[dd/mm/aaaa]\n (vacio para cancelar):\n");
		if (value.isEmpty()) {
			System.err.println("Retrocediendo...");
			return;
		} else {
			if (Utils.validateDate(value)) {
				value = Utils.formatDateSQL(value);

				if (Database.modifyUser(user.id, "birthdate", value)) {
					System.out.println("Fecha de nacimiento modificada correctamente");
				}
			}
		}
	}

	public static boolean deleteUser(User user) {
		System.err.println("Has seleccionado la opcion de eliminar usuario." + "\n¿Desea continuar con el proceso?"
				+ "\n1 - Si" + "\n2 - No");
		int option = Interface.getInt();
		if (option == 1) {
			String passwd = Utils.encryptMd5(Interface.getString("Introduce tu contraseña para continuar"));

			if (Database.verifyPassword(user.id, passwd)) {
				System.err.println("¿Estas seguro de que quieres eliminar el usuario?."
						+ "\n¿Desea continuar con el proceso?" + "\n1 - Si" + "\n2 - No");
				option = Interface.getInt();
				if (option == 1) {
					// BORRADO!
					if (Database.deleteUser(user.id)) {
						return true;
					}
				}
			}
		}

		return false;
	}
}
