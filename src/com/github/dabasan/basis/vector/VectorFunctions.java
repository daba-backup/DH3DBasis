package com.github.dabasan.basis.vector;

/**
 * Provides methods to handle vectors.
 * @author Daba
 *
 */
public class VectorFunctions {
	/**
	 * Generates a vector.
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param z Z-coordinate
	 * @return Vector
	 */
	public static Vector VGet(float x,float y,float z) {
		return new Vector(x,y,z);
	}
	/**
	 * Adds two vectors.
	 * @param lhs First vector
	 * @param rhs Second vector
	 * @return lhs+rhs
	 */
	public static Vector VAdd(Vector lhs,Vector rhs) {
		Vector res=new Vector();
		
		res.SetVector(lhs.GetX()+rhs.GetX(), lhs.GetY()+rhs.GetY(), lhs.GetZ()+rhs.GetZ());
		
		return res;
	}
	/**
	 * Subtracts a vector from another vector.
	 * @param lhs First vector
	 * @param rhs Second vector
	 * @return lhs-rhs
	 */
	public static Vector VSub(Vector lhs,Vector rhs) {
		Vector res=new Vector();
		
		res.SetVector(lhs.GetX()-rhs.GetX(), lhs.GetY()-rhs.GetY(), lhs.GetZ()-rhs.GetZ());
		
		return res;
	}
	/**
	 * Returns the size of a vector.
	 * @param v Vector
	 * @return Size of v
	 */
	public static float VSize(Vector v) {
		float size;
		float x,y,z;
		
		x=v.GetX();
		y=v.GetY();
		z=v.GetZ();
		
		size=(float)Math.sqrt(x*x+y*y+z*z);
		
		return size;
	}
	/**
	 * Returns the square size of a vector.
	 * @param v Vector
	 * @return Square size of v
	 */
	public static float VSquareSize(Vector v) {
		float size;
		float x,y,z;
		
		x=v.GetX();
		y=v.GetY();
		z=v.GetZ();
		
		size=x*x+y*y+z*z;
		
		return size;
	}
	/**
	 * Normalizes a vector.
	 * @param v Vector
	 * @return Normalized vector
	 */
	public static Vector VNorm(Vector v) {
		Vector res=new Vector();
		float size=VectorFunctions.VSize(v);
		
		res.SetVector(v.GetX()/size,v.GetY()/size,v.GetZ()/size);
		
		return res;
	}
	/**
	 * Rescales a vector.
	 * @param v Vector
	 * @param scale Scale
	 * @return Rescaled vector
	 */
	public static Vector VScale(Vector v,float scale) {
		Vector res=new Vector();
		
		res.SetVector(v.GetX()*scale, v.GetY()*scale, v.GetZ()*scale);
		
		return res;
	}
	/**
	 * Returns the dot product.
	 * @param lhs First vector
	 * @param rhs Second vector
	 * @return lhs・rhs
	 */
	public static float VDot(Vector lhs,Vector rhs) {
		float res;
		
		res=(lhs.GetX()*rhs.GetX()+lhs.GetY()*rhs.GetY()+lhs.GetZ()*rhs.GetZ());
		
		return res;
	}
	/**
	 * Returns the cross product.
	 * @param lhs First vector
	 * @param rhs Second vector
	 * @return lhs×rhs
	 */
	public static Vector VCross(Vector lhs,Vector rhs) {
		Vector res=new Vector();
		
		res.SetX(lhs.GetY()*rhs.GetZ()-lhs.GetZ()*rhs.GetY());
		res.SetY(lhs.GetZ()*rhs.GetX()-lhs.GetX()*rhs.GetZ());
		res.SetZ(lhs.GetX()*rhs.GetY()-lhs.GetY()*rhs.GetX());
		
		return res;
	}
	/**
	 * Returns the average (center) of the vector.
	 * @param v Vector
	 * @return Average
	 */
	public static Vector VAverage(Vector[] v) {
		Vector ret=VectorFunctions.VGet(0.0f, 0.0f, 0.0f);
		
		int v_num=v.length;
		for(int i=0;i<v_num;i++) {
			ret=VectorFunctions.VAdd(ret, v[i]);
		}
		ret=VectorFunctions.VScale(ret, 1.0f/v_num);
		
		return ret;
	}
	/**
	 * Returns the vertical angle of the vector.
	 * @param v Vector
	 * @return Vertical angle
	 */
	public static float VAngleV(Vector v) {
		float d=VectorFunctions.VSize(v);
		if(d<1.0E-8f)return 0.0f;
		
		float th;
		
		float sin_th=v.GetY()/d;	
		th=(float)Math.asin(sin_th);
		
		return th;
	}
	/**
	 * Returns the horizontal angle of the vector.
	 * @param v Vector
	 * @return Horizontal angle
	 */
	public static float VAngleH(Vector v) {
		Vector xz_vec=VectorFunctions.VGet(v.GetX(), 0.0f, v.GetZ());
		float xz_length=VectorFunctions.VSize(xz_vec);
		if(xz_length<1.0E-8f)return 0.0f;
		
		float th;
		
		float cos_th=v.GetX()/xz_length;
		th=(float)Math.acos(cos_th);
		
		if(v.GetZ()>=0.0f)th*=(-1.0f);
		
		return th;
	}
	/**
	 * Returns a normalized vector obtained from the specified rotation angles.
	 * @param v_rotate Vertical rotation angle
	 * @param h_rotate Horizontal rotation angle
	 * @return Vector
	 */
	public static Vector VGetFromAngles(float v_rotate,float h_rotate) {
		Vector ret=new Vector();
		
		ret.SetX((float)Math.cos(h_rotate));
		ret.SetY((float)Math.sin(v_rotate));
		ret.SetZ(-(float)Math.sin(h_rotate));
		
		ret=VectorFunctions.VNorm(ret);
		
		return ret;
	}
}
