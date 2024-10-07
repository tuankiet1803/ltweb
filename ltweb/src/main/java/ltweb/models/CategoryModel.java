package ltweb.models;

import java.io.Serializable;

public class CategoryModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String image;
	private int status;

	public CategoryModel() {
		super();
	}

	public CategoryModel(int id, String name, String image, int status) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CategoryModel [id=" + id + ", name=" + name + ", image=" + image + ", status=" + status + "]";
	}

}
