package service;

import dto.*;
import repository.MachineRepository;

import java.util.List;

public class AdminService {
    MachineRepository machineRepository = new MachineRepository();

    public int insertProductService(ProductDto productDto) {
        return machineRepository.insertProduct(productDto);
    }
    public int insertMemberService(MemberDto memberDto) {
        return machineRepository.insertMember(memberDto);
    }

    public int updateProductService(ProductDto productDto) {
        return machineRepository.updateProduct(productDto);
    }

    public int updateMemberService(MemberDto memberDto) {
        return machineRepository.updateMember(memberDto);
    }

    public int deleteMemberService(String member_id) {
        return machineRepository.deleteMember(member_id);
    }

    public int deleteProductService(int productId) {
        return machineRepository.deleteProduct(productId);
    }
    public ProductDto findByProductIdService(int productId) {
        return machineRepository.findByProductId(productId);
    }

    public MemberDto findByMemberIdService(String memberId) {
        return machineRepository.findByMemberId(memberId);
    }

    public List<SearchResultProductDto> findByProductNameService(String name) {
        return machineRepository.findByNameProduct(name);
    }
    public List<SearchResultMemberDto> findByMemberCheckService(String memberId) {
        return machineRepository.findByMemberCheck(memberId);
    }

    // 판매현황
    public List<SalesDto> getProductSalesService () {
        return machineRepository.getProductSales();
    }

    public List<SalesDto> getMemberSalesService () {
        return machineRepository.getMemberSales();
    }
}

