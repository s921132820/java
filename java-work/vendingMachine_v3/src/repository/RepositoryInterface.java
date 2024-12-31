package repository;

import dto.MemberDto;
import dto.ProductDto;

import java.util.List;

public interface RepositoryInterface {
    int insertMember(MemberDto memberDto);

    int updateMember(MemberDto memberDto);

    int deleteDate(String id);

    // 전체 데이터 읽어오기
    List<MemberDto> getAllList();

    List<ProductDto> getProductList();

    //  ID로 검색
    MemberDto findById(String id);

    MemberDto findByMemberId(String id);

    ProductDto findByProductId(int productId);

    // 이름으로 검색
//    List<SearchResultDTO> findByName(String name);

    // 전화번호로 검색
//    List<SearchResultDTO> findByPhone(String phone);
}
