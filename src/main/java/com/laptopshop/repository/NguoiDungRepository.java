package com.laptopshop.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptopshop.entities.NguoiDung;
import com.laptopshop.entities.VaiTro;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long>{

	NguoiDung findByEmail(String email);

	@Query("SELECT n FROM NguoiDung n WHERE n.vaiTro IN :vaiTros")
	Page<NguoiDung> findByVaiTro(@Param("vaiTros") Set<VaiTro> vaiTro, Pageable pageable);

	@Query("SELECT n FROM NguoiDung n WHERE n.vaiTro IN :vaiTros")
	List<NguoiDung> findByVaiTro(@Param("vaiTros") Set<VaiTro> vaiTro);
}
