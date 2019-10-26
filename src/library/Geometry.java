package library;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

public abstract class Geometry {
	private Model model;
	private Texture texture;
	private static Shader shader=new Shader("shaderSimple");
	
	private Matrix4f position=new Matrix4f(); 
	
	private Vector4f color;
	
	public Geometry(Vector4f color) {
		this.color=color;
	}
	
	public abstract Model createModel();
	public abstract Texture createTexture();
	
	
	public void setColor(Vector4f color) {
		this.color=color;
	}
	
	
	public void translate(Vector3f vec,float width,float height ) {
		position=new Matrix4f();
		position.translate(vec).scale(width, height, 0);
	}
	
	
	public void render(Camera camera) {
		shader.bind();
		
		
		shader.setUniform("color", color);
		
		shader.setUniform("projection", camera.getProjection().mul(position));
		model.render();
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}


	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Matrix4f getPosition() {
		return position;
	}

	public void setPosition(Matrix4f position) {
		this.position = position;
	}

	public static Shader getShader() {
		return shader;
	}

	public static void setShader(Shader shader) {
		Geometry.shader = shader;
	}
	
	
	

	
	
	
}
