package com.daxie.basis.matrix;

import com.daxie.basis.vector.Vector;

/**
 * Provides methods to handle matrices.
 * @author Daba
 *
 */
public class MatrixFunctions {
	/**
	 * Multiplies two matrices together.
	 * @param m1 First matrix
	 * @param m2 Second matrix
	 * @return m1*m2
	 */
	public static Matrix MMult(Matrix m1,Matrix m2) {
		Matrix ret=new Matrix();
		
		float value;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				value=0.0f;
				
				for(int k=0;k<4;k++) {
					value+=m1.GetValue(i, k)*m2.GetValue(k, j);
				}
				
				ret.SetValue(i, j, value);
			}
		}
		
		return ret;
	}
	/**
	 * Returns an identity matrix.
	 * @return Identity matrix
	 */
	public static Matrix MGetIdent() {
		Matrix ret=new Matrix();
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++)ret.SetValue(i, j, 0.0f);
		}
		for(int i=0;i<4;i++)ret.SetValue(i, i, 1.0f);
		
		return ret;
	}
	/**
	 * Returns a scaling matrix.
	 * @param scale Scaling vector
	 * @return Scaling matrix
	 */
	public static Matrix MGetScale(Vector scale) {
		Matrix ret=new Matrix();
		
		ret.SetValue(0, 0, scale.GetX());
		ret.SetValue(0, 1, 0.0f);
		ret.SetValue(0, 2, 0.0f);
		ret.SetValue(0, 3, 0.0f);
		ret.SetValue(1, 0, 0.0f);
		ret.SetValue(1, 1, scale.GetY());
		ret.SetValue(1, 2, 0.0f);
		ret.SetValue(1, 3, 0.0f);
		ret.SetValue(2, 0, 0.0f);
		ret.SetValue(2, 1, 0.0f);
		ret.SetValue(2, 2, scale.GetZ());
		ret.SetValue(2, 3, 0.0f);
		ret.SetValue(3, 0, 0.0f);
		ret.SetValue(3, 1, 0.0f);
		ret.SetValue(3, 2, 0.0f);
		ret.SetValue(3, 3, 1.0f);
		
		return ret;
	}
	/**
	 * Returns a translation matrix.
	 * @param translate Translation vector
	 * @return Translation matrix
	 */
	public static Matrix MGetTranslate(Vector translate) {
		Matrix ret=new Matrix();
		
		ret.SetValue(0, 0, 1.0f);
		ret.SetValue(0, 1, 0.0f);
		ret.SetValue(0, 2, 0.0f);
		ret.SetValue(0, 3, translate.GetX());
		ret.SetValue(1, 0, 0.0f);
		ret.SetValue(1, 1, 1.0f);
		ret.SetValue(1, 2, 0.0f);
		ret.SetValue(1, 3, translate.GetY());
		ret.SetValue(2, 0, 0.0f);
		ret.SetValue(2, 1, 0.0f);
		ret.SetValue(2, 2, 1.0f);
		ret.SetValue(2, 3, translate.GetZ());
		ret.SetValue(3, 0, 0.0f);
		ret.SetValue(3, 1, 0.0f);
		ret.SetValue(3, 2, 0.0f);
		ret.SetValue(3, 3, 1.0f);
		
		return ret;
	}
	/**
	 * Returns a rotation matrix around x-axis.
	 * @param th Rotation angle (radian)
	 * @return Rotation matrix
	 */
	public static Matrix MGetRotX(float th) {
		Matrix ret=new Matrix();
		
		ret.SetValue(0, 0, 1.0f);
		ret.SetValue(0, 1, 0.0f);
		ret.SetValue(0, 2, 0.0f);
		ret.SetValue(0, 3, 0.0f);
		ret.SetValue(1, 0, 0.0f);
		ret.SetValue(1, 1, (float)Math.cos(th));
		ret.SetValue(1, 2, (float)-Math.sin(th));
		ret.SetValue(1, 3, 0.0f);
		ret.SetValue(2, 0, 0.0f);
		ret.SetValue(2, 1, (float)Math.sin(th));
		ret.SetValue(2, 2, (float)Math.cos(th));
		ret.SetValue(2, 3, 0.0f);
		ret.SetValue(3, 0, 0.0f);
		ret.SetValue(3, 1, 0.0f);
		ret.SetValue(3, 2, 0.0f);
		ret.SetValue(3, 3, 1.0f);
		
		return ret;
	}
	/**
	 * Returns a rotation matrix around y-axis.
	 * @param th Rotation angle (radian)
	 * @return Rotation matrix
	 */
	public static Matrix MGetRotY(float th) {
		Matrix ret=new Matrix();
		
		ret.SetValue(0, 0, (float)Math.cos(th));
		ret.SetValue(0, 1, 0.0f);
		ret.SetValue(0, 2, (float)Math.sin(th));
		ret.SetValue(0, 3, 0.0f);
		ret.SetValue(1, 0, 0.0f);
		ret.SetValue(1, 1, 1.0f);
		ret.SetValue(1, 2, 0.0f);
		ret.SetValue(1, 3, 0.0f);
		ret.SetValue(2, 0, (float)-Math.sin(th));
		ret.SetValue(2, 1, 0.0f);
		ret.SetValue(2, 2, (float)Math.cos(th));
		ret.SetValue(2, 3, 0.0f);
		ret.SetValue(3, 0, 0.0f);
		ret.SetValue(3, 1, 0.0f);
		ret.SetValue(3, 2, 0.0f);
		ret.SetValue(3, 3, 1.0f);
		
		return ret;
	}
	/**
	 * Returns a rotation matrix around z-axis.
	 * @param th Rotation angle (radian)
	 * @return Rotation matrix
	 */
	public static Matrix MGetRotZ(float th) {
		Matrix ret=new Matrix();
		
		ret.SetValue(0, 0, (float)Math.cos(th));
		ret.SetValue(0, 1, (float)-Math.sin(th));
		ret.SetValue(0, 2, 0.0f);
		ret.SetValue(0, 3, 0.0f);
		ret.SetValue(1, 0, (float)Math.sin(th));
		ret.SetValue(1, 1, (float)Math.cos(th));
		ret.SetValue(1, 2, 0.0f);
		ret.SetValue(1, 3, 0.0f);
		ret.SetValue(2, 0, 0.0f);
		ret.SetValue(2, 1, 0.0f);
		ret.SetValue(2, 2, 1.0f);
		ret.SetValue(2, 3, 0.0f);
		ret.SetValue(3, 0, 0.0f);
		ret.SetValue(3, 1, 0.0f);
		ret.SetValue(3, 2, 0.0f);
		ret.SetValue(3, 3, 1.0f);
		
		return ret;
	}
	/**
	 * Returns a rotation matrix around an arbitrary axis.
	 * @param axis Axis
	 * @param th Rotation angle (radian)
	 * @return Rotation matrix
	 */
	public static Matrix MGetRotAxis(Vector axis,float th) {
		Matrix ret=new Matrix();
		
		float cos_th=(float)Math.cos(th);
		float sin_th=(float)Math.sin(th);
		float nx=axis.GetX();
		float ny=axis.GetY();
		float nz=axis.GetZ();
		
		ret.SetValue(0, 0, cos_th+nx*nx*(1.0f-cos_th));
		ret.SetValue(0, 1, nx*ny*(1.0f-cos_th)-nz*sin_th);
		ret.SetValue(0, 2, nx*nz*(1.0f-cos_th)+ny*sin_th);
		ret.SetValue(0, 3, 0.0f);
		ret.SetValue(1, 0, ny*nx*(1.0f-cos_th)+nz*sin_th);
		ret.SetValue(1, 1, cos_th+ny*ny*(1.0f-cos_th));
		ret.SetValue(1, 2, ny*nz*(1.0f-cos_th)-nx*sin_th);
		ret.SetValue(1, 3, 0.0f);
		ret.SetValue(2, 0, nz*nx*(1.0f-cos_th)-ny*sin_th);
		ret.SetValue(2, 1, nz*ny*(1.0f-cos_th)+nx*sin_th);
		ret.SetValue(2, 2, cos_th+nz*nz*(1.0f-cos_th));
		ret.SetValue(2, 3, 0.0f);
		ret.SetValue(3, 0, 0.0f);
		ret.SetValue(3, 1, 0.0f);
		ret.SetValue(3, 2, 0.0f);
		ret.SetValue(3, 3, 1.0f);
		
		return ret;
	}
	/**
	 * Transposes a matrix.
	 * @param m Original matrix
	 * @return Transposed matrix
	 */
	public static Matrix MTranspose(Matrix m) {
		Matrix ret=new Matrix();
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				ret.SetValue(i, j, m.GetValue(j, i));
			}
		}
		
		return ret;
	}
	/**
	 * Returns a 4 by 4 magic square.
	 * @return Magic square
	 */
	public static Matrix MGetMagic() {
		Matrix ret=new Matrix();
		
		ret.SetValue(0, 0, 16);
		ret.SetValue(0, 1, 2);
		ret.SetValue(0, 2, 3);
		ret.SetValue(0, 3, 13);
		ret.SetValue(1, 0, 5);
		ret.SetValue(1, 1, 11);
		ret.SetValue(1, 2, 10);
		ret.SetValue(1, 3, 8);
		ret.SetValue(2, 0, 9);
		ret.SetValue(2, 1, 7);
		ret.SetValue(2, 2, 6);
		ret.SetValue(2, 3, 12);
		ret.SetValue(3, 0, 4);
		ret.SetValue(3, 1, 14);
		ret.SetValue(3, 2, 15);
		ret.SetValue(3, 3, 1);
		
		return ret;
	}
	/**
	 * Returns the determinant of a matrix.
	 * @param m Matrix
	 * @return Determinant
	 */
	public static float MGetDet(Matrix m) {
		float ret=0.0f;
		
		float a00=m.GetValue(0, 0);
		float a01=m.GetValue(0, 1);
		float a02=m.GetValue(0, 2);
		float a03=m.GetValue(0, 3);
		float a10=m.GetValue(1, 0);
		float a11=m.GetValue(1, 1);
		float a12=m.GetValue(1, 2);
		float a13=m.GetValue(1, 3);
		float a20=m.GetValue(2, 0);
		float a21=m.GetValue(2, 1);
		float a22=m.GetValue(2, 2);
		float a23=m.GetValue(2, 3);
		float a30=m.GetValue(3, 0);
		float a31=m.GetValue(3, 1);
		float a32=m.GetValue(3, 2);
		float a33=m.GetValue(3, 3);
		
		ret=a00*(a11*a22*a33+a12*a23*a31+a13*a21*a32-a13*a22*a31-a12*a21*a33-a11*a23*a32)
				-a10*(a01*a22*a33+a02*a23*a31+a03*a21*a32-a03*a22*a31-a02*a21*a33-a01*a23*a32)
				+a20*(a01*a12*a33+a02*a13*a31+a03*a11*a32-a03*a12*a31-a02*a11*a33-a01*a13*a32)
				-a30*(a01*a12*a23+a02*a13*a21+a03*a11*a22-a03*a12*a21-a02*a11*a23-a01*a13*a22);
		
		return ret;
	}
	/**
	 * Returns an inverse matrix.
	 * @param m Original matrix
	 * @return Inverse matrix
	 */
	public static Matrix MInverse(Matrix m) {
		Matrix ret=new Matrix();
		
		float a11=m.GetValue(0, 0);
		float a12=m.GetValue(0, 1);
		float a13=m.GetValue(0, 2);
		float a14=m.GetValue(0, 3);
		float a21=m.GetValue(1, 0);
		float a22=m.GetValue(1, 1);
		float a23=m.GetValue(1, 2);
		float a24=m.GetValue(1, 3);
		float a31=m.GetValue(2, 0);
		float a32=m.GetValue(2, 1);
		float a33=m.GetValue(2, 2);
		float a34=m.GetValue(2, 3);
		float a41=m.GetValue(3, 0);
		float a42=m.GetValue(3, 1);
		float a43=m.GetValue(3, 2);
		float a44=m.GetValue(3, 3);
		
		Matrix cofactor=new Matrix();
		cofactor.SetValue(0, 0, a22*a33*a44+a23*a34*a42+a24*a32*a43-a24*a33*a42-a23*a32*a44-a22*a34*a43);
		cofactor.SetValue(0, 1, -a12*a33*a44-a13*a34*a42-a14*a32*a43+a14*a33*a42+a13*a32*a44+a12*a34*a43);
		cofactor.SetValue(0, 2, a12*a23*a44+a13*a24*a42+a14*a22*a43-a14*a23*a42-a13*a22*a44-a12*a24*a43);
		cofactor.SetValue(0, 3, -a12*a23*a34-a13*a24*a32-a14*a22*a33+a14*a23*a32+a13*a22*a34+a12*a24*a33);
		cofactor.SetValue(1, 0, -a21*a33*a44-a23*a34*a41-a24*a31*a43+a24*a33*a41+a23*a31*a44+a21*a34*a43);
		cofactor.SetValue(1, 1, a11*a33*a44+a13*a34*a41+a14*a31*a43-a14*a33*a41-a13*a31*a44-a11*a34*a43);
		cofactor.SetValue(1, 2, -a11*a23*a44-a13*a24*a41-a14*a21*a43+a14*a23*a41+a13*a21*a44+a11*a24*a43);
		cofactor.SetValue(1, 3, a11*a23*a34+a13*a24*a31+a14*a21*a33-a14*a23*a31-a13*a21*a34-a11*a24*a33);
		cofactor.SetValue(2, 0, a21*a32*a44+a22*a34*a41+a24*a31*a42-a24*a32*a41-a22*a31*a44-a21*a34*a42);
		cofactor.SetValue(2, 1, -a11*a32*a44-a12*a34*a41-a14*a31*a42+a14*a32*a41+a12*a31*a44+a11*a34*a42);
		cofactor.SetValue(2, 2, a11*a22*a44+a12*a24*a41+a14*a21*a42-a14*a22*a41-a12*a21*a44-a11*a24*a42);
		cofactor.SetValue(2, 3, -a11*a22*a34-a12*a24*a31-a14*a21*a32+a14*a22*a31+a12*a21*a34+a11*a24*a32);
		cofactor.SetValue(3, 0, -a21*a32*a43-a22*a33*a41-a23*a31*a42+a23*a32*a41+a22*a31*a43+a21*a33*a42);
		cofactor.SetValue(3, 1, a11*a32*a43+a12*a33*a41+a13*a31*a42-a13*a32*a41-a12*a31*a43-a11*a33*a42);
		cofactor.SetValue(3, 2, -a11*a22*a43-a12*a23*a41-a13*a21*a42+a13*a22*a41+a12*a21*a43+a11*a23*a42);
		cofactor.SetValue(3, 3, a11*a22*a33+a12*a23*a31+a13*a21*a32-a13*a22*a31-a12*a21*a33-a11*a23*a32);
		
		float det=MatrixFunctions.MGetDet(m);
		float rec_det=1.0f/det;
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				ret.SetValue(i, j, cofactor.GetValue(i, j)*rec_det);
			}
		}
		
		return ret;
	}
}
