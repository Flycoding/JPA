package com.flyingh.jpa.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Line {
	private PK pk;
	private String info;

	public Line() {
	}

	public Line(PK pk, String info) {
		this.pk = pk;
		this.info = info;
	}

	@EmbeddedId
	public PK getPk() {
		return pk;
	}

	public void setPk(PK pk) {
		this.pk = pk;
	}

	@Column(length = 20)
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Embeddable
	public static class PK implements Serializable {
		private static final long serialVersionUID = 1745782627999211215L;
		private String from;
		private String to;

		public PK() {
			super();
		}

		public PK(String from, String to) {
			super();
			this.from = from;
			this.to = to;
		}

		@Column(name = "_from", length = 3)
		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		@Column(name = "_to", length = 3)
		public String getTo() {
			return to;
		}

		public void setTo(String to) {
			this.to = to;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (from == null ? 0 : from.hashCode());
			result = prime * result + (to == null ? 0 : to.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final PK other = (PK) obj;
			if (from == null) {
				if (other.from != null) {
					return false;
				}
			} else if (!from.equals(other.from)) {
				return false;
			}
			if (to == null) {
				if (other.to != null) {
					return false;
				}
			} else if (!to.equals(other.to)) {
				return false;
			}
			return true;
		}

	}
}
